package io.foldright.demo.cffu2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static io.foldright.cffu2.CompletableFutureUtils.anySuccessOf;
import static io.foldright.cffu2.CompletableFutureUtils.orTimeout;

public class CompletableFutureUtilsDemo {

    private static final ExecutorService myBizThreadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
