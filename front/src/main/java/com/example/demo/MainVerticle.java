package com.example.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.templ.ThymeleafTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);
    private static final int PORT = 8081;

    /*
    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
              LOGGER.info("Access!");
              req.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Vert.x!");
            }).listen(8080);
        System.out.println("HTTP server started on port 8080");
    }
    */

    // ThymeleafTemplateEnging
    @Override
    public void start() throws Exception {
        // To simplify the development of the web components we use a Router to route all HTTP requests
        // to organize our code in a reusable way.
        final Router router = Router.router(vertx);

        // In order to use a Thymeleaf template we first need to create an engine
        final ThymeleafTemplateEngine engine = ThymeleafTemplateEngine.create();

        router.get().handler(ctx -> {
            // we define a hardcoded title for our application
            ctx.put("welcome", "Hi there!");

            // and now delegate to the engine to render it.
            engine.render(ctx, "templates/index.html", res -> {
                if (res.succeeded()) {
                    LOGGER.info("Access!");
                    ctx.response().end(res.result());
                } else {
                    ctx.fail(res.cause());
                }
            });
        });

        // start a HTTP web server on port 8080
        vertx.createHttpServer().requestHandler(router::accept).listen(PORT);
        LOGGER.info("HTTP server started on port " + PORT);
    }
}
