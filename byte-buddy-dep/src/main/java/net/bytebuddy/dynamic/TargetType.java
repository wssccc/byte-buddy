package net.bytebuddy.dynamic;

import net.bytebuddy.instrumentation.type.TypeDescription;
import net.bytebuddy.instrumentation.type.TypeList;

import java.util.ArrayList;
import java.util.List;

/**
 * This type is used as a place holder for creating methods or fields that refer to the type that currently subject
 * of creation within a {@link net.bytebuddy.dynamic.DynamicType.Builder}.
 */
public final class TargetType {

    /**
     * A description representation of the {@link net.bytebuddy.dynamic.TargetType}.
     */
    public static final TypeDescription DESCRIPTION = new TypeDescription.ForLoadedType(TargetType.class);

    public static TypeDescription resolve(TypeDescription typeDescription, TypeDescription instrumentedType) {
        return typeDescription.represents(TargetType.class)
                ? instrumentedType
                : typeDescription;
    }

    public static TypeList resolve(List<? extends TypeDescription> typeList, TypeDescription instrumentedType) {
        List<TypeDescription> typeDescriptions = new ArrayList<TypeDescription>(typeList.size());
        for (TypeDescription typeDescription : typeList) {
            typeDescriptions.add(resolve(typeDescription, instrumentedType));
        }
        return new TypeList.Explicit(typeDescriptions);
    }

    /**
     * As the {@link net.bytebuddy.dynamic.TargetType} is only to be used as a marker, its constructor is made inaccessible.
     */
    private TargetType() {
        throw new UnsupportedOperationException("This is a place holder type that should not be instantiated");
    }
}