package ie.gmit.ds;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class grpcServer {
    private Server grpcserver;
    private static final Logger logger = Logger.getLogger(grpcServer.class.getName());
    private static final int PORT = 50551;

    //Starts the server
    private void start() throws IOException {
        grpcserver = ServerBuilder.forPort(PORT)
                .addService(new grpcServiceImpl())
                .build()
                .start();
        logger.info("Server launch successful, Port: " + PORT);

    }
    //Shuts down the server
    private void stop() {
        if (grpcserver != null) {
            grpcserver.shutdown();
        }
    }//stop

   //awaits the main thread termination
    private void blockUntilShutdown() throws InterruptedException {
        if (grpcserver != null) {
            grpcserver.awaitTermination();
        }//blockUntilShutdown
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        final grpcServer grpcServiceServer = new grpcServer();
        grpcServiceServer.start();
        grpcServiceServer.blockUntilShutdown();
    }//main
}//grpcServer