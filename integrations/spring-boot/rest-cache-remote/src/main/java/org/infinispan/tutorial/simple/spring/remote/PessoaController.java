package org.infinispan.tutorial.simple.spring.remote;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PessoaController {

    private RemoteCache<String, Pessoa> remoteCache;

    public PessoaController(RemoteCacheManager remoteCacheManager) {
        this.remoteCache = remoteCacheManager.getCache(Data.PESSOAS_CACHE);
      // Upload the generated schema in the server
      RemoteCache<String, String> metadataCache = remoteCacheManager.getCache(ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME);
      GeneratedSchema schema = new PessoasSchemaBuilderImpl();
      metadataCache.put(schema.getProtoFileName(), schema.getProtoFile());
    }

    // curl -X GET localhost:8080/pessoas/1
    @GetMapping("/pessoas/{id}")
    Pessoa get(@PathVariable String id) {
        return remoteCache.get(id);
    }

    // curl -X POST -H 'Content-type: application/json' -d '{"id":"1","name":"Vinicius"}' localhost:8080/pessoas
    @PostMapping("/pessoas")
    void post(@RequestBody PessoaDTO pessoa) {
        remoteCache.put(pessoa.getId(), new Pessoa(pessoa.getId(), pessoa.getName()));
    }

    // curl -X DELETE localhost:8080/pessoas/1
    @DeleteMapping("/pessoas/{id}")
    void delete(@PathVariable String id) {
        remoteCache.remove(id);
    }
}
