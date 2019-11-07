package ie.gmit.ds;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class grpcServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {
    private static final Logger logger = Logger.getLogger(grpcServiceImpl.class.getName());
    //Variables
    private char[] charPassword;
    private boolean validPassword;
    private byte[] salt;
    private byte[] expectedHash;

    //Store userId
    private int userId;

    //Constructor
    public grpcServiceImpl() {
    }//constructor

    @Override
    public void hash(HashRequest request, StreamObserver<HashResponse> responseObserver) {
        try {
            // Get userID,Salt
            userId = request.getUserId();
            salt = Passwords.getNextSalt();

            // Converts password into a CharArray
            charPassword = request.getPassword().toCharArray();
            //Hashes the charArray with the Salt
            expectedHash = Passwords.hash(charPassword, salt);

            HashResponse hashResponse = HashResponse.newBuilder()
                    .setUserId(userId)
                    .setSalt(ByteString.copyFrom(salt))
                    .setExpectedHash(ByteString.copyFrom(expectedHash))
                    .build();
           //Log
            logger.info(String.format("Hash Response: %s", hashResponse));
            //Send to the client
            responseObserver.onNext(hashResponse);
        } catch (RuntimeException except) {
            logger.warning(String.format("Hash Error: %s", except));
        }//try/Catch
        //Commit
        responseObserver.onCompleted();
    }//hash

   //Password validation
    @Override
    public void validate(ValidateRequest request, StreamObserver<ValidateResponse> responseObserver) {
       //Log
        logger.info(String.format("Validation Request: %s", request));
        try {
            //Get the password,Salt,ExpectedHash
            charPassword = request.getPassword().toCharArray();
            salt = request.getSalt().toByteArray();
            expectedHash = request.getExpectedHash().toByteArray();
            //Verifies password is correct
            validPassword = Passwords.isExpectedPassword(charPassword, salt, expectedHash);

            ValidateResponse validateResponse = ValidateResponse.newBuilder()
                    .setValidPassword(validPassword)
                    .build();
            responseObserver.onNext(validateResponse);
        } catch (RuntimeException except) {
            System.out.println(except);
            logger.warning(String.format("Validation Error", except));
        }//try/Catch
        //Commit
        responseObserver.onCompleted();
    }//validate
}//grpcServiceImpl

