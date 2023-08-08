package org.infinispan.tutorial.simple.spring.remote;

public class PessoaDTO {

   private String id;
   private String name;

   public String getId() {
      return id;
   }

   public String getName() {
      return this.name;
   }


   public void setId(String id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }


   @Override
   public String toString() {
      return "PessoaDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
   }
}
