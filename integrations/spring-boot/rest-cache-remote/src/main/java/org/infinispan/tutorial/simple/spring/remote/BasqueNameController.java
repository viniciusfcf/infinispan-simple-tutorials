package org.infinispan.tutorial.simple.spring.remote;

import java.util.List;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class BasqueNameController {

    private RemoteCache<String, BasqueName> remoteCache;

    public BasqueNameController(RemoteCacheManager remoteCacheManager) {
        this.remoteCache = remoteCacheManager.getCache(Data.BASQUE_NAMES_CACHE);
    }

    @GetMapping("/basque-names")
    BasqueName get() {
        remoteCache.put("1", new BasqueName("1", "Vinicius"));
        return remoteCache.get("1");
    }
}
