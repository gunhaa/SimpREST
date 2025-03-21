package simple;

import simple.server.Server;
import simple.server.SingleThreadServer;
import simple.tempEntity.Member;
import simple.response.ResponseError;
import simple.response.ResponseSuccess;

import java.io.IOException;

import static simple.constant.HttpStatus.BAD_REQUEST_400;
import static simple.constant.HttpStatus.OK_200;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("실행 테스트");
        Server app = new SingleThreadServer();

        app.get(
                "/members",
                new ResponseSuccess(OK_200, new Member("gunha", 10)),
                new ResponseError(BAD_REQUEST_400, "Not Found")
        );


        app.run(8020);
    }
}