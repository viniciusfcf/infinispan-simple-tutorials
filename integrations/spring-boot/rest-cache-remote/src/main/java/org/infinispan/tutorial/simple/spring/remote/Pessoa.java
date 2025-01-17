package org.infinispan.tutorial.simple.spring.remote;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.util.Objects;

public class Pessoa {

   private final String id;
   private final String name;

   @ProtoFactory
   public Pessoa(String id, String name) {
      this.id = id;
      this.name = name;
   }

   @ProtoField(value = 1, required = true)
   public String getId() {
      return id;
   }

   @ProtoField(value = 2, required = true)
   public String getName() {
      return this.name;
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pessoa that = (Pessoa) o;
      return Objects.equals(id, that.id) &&
            Objects.equals(name, that.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name);
   }

   @Override
   public String toString() {
      return "Pessoa{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
   }
}
