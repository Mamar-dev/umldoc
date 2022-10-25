package com.github.forax.umldoc.classfile;

import static java.util.Objects.requireNonNull;

import com.github.forax.umldoc.core.Entity;
import com.github.forax.umldoc.core.Field;
import com.github.forax.umldoc.core.Modifier;
import com.github.forax.umldoc.core.TypeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A builder of an entity.
 */
final class EntityBuilder {
  private TypeInfo type;
  private Entity.Stereotype stereotype;
  private final ArrayList<Field> fields = new ArrayList<>();

  public void type(TypeInfo type) {
    requireNonNull(type);
    this.type = type;
  }

  public TypeInfo type() {
    return type;
  }

  public void stereotype(Entity.Stereotype stereotype) {
    requireNonNull(stereotype);
    this.stereotype = stereotype;
  }

  public void addField(Set<Modifier> modifiers, String name, TypeInfo type) {
    requireNonNull(modifiers);
    requireNonNull(name);
    requireNonNull(type);
    fields.add(new Field(modifiers, name, type));
  }

  public Entity build() {
    return new Entity(Set.of(), type, stereotype, fields, List.of());
  }
}