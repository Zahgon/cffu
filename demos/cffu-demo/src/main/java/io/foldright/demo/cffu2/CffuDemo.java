package io.foldright.demo.cffu2;

import io.foldright.cffu2.Cffu;
import io.foldright.cffu2.CffuFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CffuDemo {

    private static final ExecutorService myBizThreadPool = Executors.newCachedThreadPool();

    // create a CffuFactory with configuration of the customized thread pool
    private static final CffuFactory cffuFactory = CffuFactory.builder(myBizThreadPool).build();

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
