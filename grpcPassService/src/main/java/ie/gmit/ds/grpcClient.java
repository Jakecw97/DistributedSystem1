package ie.gmit.ds;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.logging.Level;
import java.util.logging.Logger;

    public class grpcClient {
        //Synchronous and Asynchronous initialisation
        private static final Logger logger = Logger.getLogger(grpcClient.class.getName());
        private final ManagedChannel channel;
        private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;
        //Host and Port
        private static final String HOST = "localhost";
        private static final int PORT = 50551;

        //User Variables
        private int userId;
        private String password;
        private byte[] salt;
        private byte[] expectedHash;


        public grpcClient(String host, int port) {
            channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
            syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
        }//grpcClient

        public int getUserId()
        {
            return userId;
        }//getUserID

        public void setUserId(int userId) { this.userId = userId;}//setUserId

        public String getPassword() { return password; }//getPassword

        public void setPassword(String password) { this.password = password; }//setPassword

        public byte[] getSalt() { return salt; }//getSalt

        public void setSalt(byte[] salt) {
            this.salt = salt;
        }//setSalt

        public byte[] getExpectedHash() { return expectedHash; }//getExpectedHas

        public void setExpectedHash(byte[] expectedHash) { this.expectedHash = expectedHash; }//setHash

        //Hashes password
        public void Hash(int userId, String password) {
            HashRequest hashRequest;
            logger.info("Hash Request\nUser ID: " + userId + "\nPassword: " + password);
            try {
                //Creates a request
                hashRequest = HashRequest.newBuilder()
                        .setUserId(userId)
                        .setPassword(password)
                        .build();
            } catch (StatusRuntimeException ex) {
                logger.log(Level.WARNING, "Hash Request Failed", ex.getStatus());
                return;
            }//try/catch
            HashResponse hashResponse = syncPasswordService.hash(hashRequest);
            //Log the response
            logger.info("Hash Response\nUserId: " + userId
                    + "\nSalt: " + hashResponse.getExpectedHash().toByteArray()
                    + "\nHashed Password: " + hashResponse.getSalt().toByteArray());

            //Set global variables
            setUserId(userId);
            setPassword(password);
            setSalt(hashResponse.getSalt().toByteArray());
            setExpectedHash(hashResponse.getExpectedHash().toByteArray());
        }//Hash
        //Password validation
        public void Validate(String password, byte[] salt, byte[] expectedHash) {
            ValidateRequest validateRequest;
            try {
                //Creates a request
                validateRequest = ValidateRequest.newBuilder()
                        .setPassword(password)
                        .setSalt(ByteString.copyFrom(salt))
                        .setExpectedHash(ByteString.copyFrom(expectedHash))
                        .build();
            } catch (StatusRuntimeException ex) {
                logger.log(Level.WARNING, "Validation Request Failed", ex.getStatus());
                return;
            }
            ValidateResponse validateResponse = syncPasswordService.validate(validateRequest);
            logger.info("Validate Request\nPassword:" + password + "\nSalt:" + salt + "\nHashed Password:" + expectedHash); // Logging request
            logger.info("Validation Response\nIs Password Valid:" + validateResponse.getValidPassword()); // Logging response
        }//Validate

        public static void main(String[] args) throws InterruptedException {
            grpcClient grpcclient = new grpcClient(HOST, PORT);

            try {
                //Hash Test
                grpcclient.Hash(66, "Toma");
                grpcclient.Hash(43, "Josh");
                grpcclient.Hash(23, "Alan");
                grpcclient.Hash(31, "Pying");

                //Test validate
                byte[] salt = Passwords.getNextSalt();
                grpcclient.Validate("Toma", Passwords.hash("Toma".toCharArray(), salt), salt);
            } finally {
                Thread.currentThread().join();
            }//try
        }//main
    }//grpcClient

