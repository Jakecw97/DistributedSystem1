package ie.gmit.ds;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UserApiServiceApp extends Application<UserApiServiceConfig> {

    @Override
    public void run(UserApiServiceConfig userApiServiceConfig, Environment environment) throws Exception {

        final UserHealthCheck healthCheck = new UserHealthCheck();
        final UserApiServiceResource resource = new UserApiServiceResource();
        environment.jersey().register(resource);
        environment.healthChecks().register("User1", healthCheck);
    }//run

    public static void main(String[] args) throws Exception {
        System.out.println("Starting");
        new UserApiServiceApp().run(args);

    }//main
}//UserApiServiceApplication

