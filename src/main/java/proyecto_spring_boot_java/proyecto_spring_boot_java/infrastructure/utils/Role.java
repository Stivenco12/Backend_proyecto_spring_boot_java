package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.utils;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ROLE_ADMINISTRATOR(Arrays.asList(
        RolePermission.READ_ALL_PRODUCTS,
        RolePermission.READ_ONE_PRODUCT,
        RolePermission.CREATE_ONE_PRODUCT,
        RolePermission.UPDATE_ONE_PRODUCT,
        RolePermission.DISABLE_ONE_PRODUCT,
        RolePermission.READ_ALL_CATEGORIES,
        RolePermission.READ_ONE_CATEGORY,
        RolePermission.CREATE_ONE_CATEGORY,
        RolePermission.UPDATE_ONE_CATEGORY,
        RolePermission.DISABLE_ONE_CATEGORY,
        RolePermission.READ_MY_PROFILE

    )),
    ROLE_CUSTOMER(Arrays.asList(
        RolePermission.READ_MY_PROFILE
    )),
    ROLE_SUPPLIER(Arrays.asList(
        RolePermission.READ_ALL_PRODUCTS,
        RolePermission.READ_ONE_PRODUCT,
        RolePermission.READ_ALL_CATEGORIES,
        RolePermission.READ_ONE_CATEGORY,
        RolePermission.READ_MY_PROFILE
    ));

    private List<RolePermission> permissions;

    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }
    public static boolean isValidRole(String roleName) {
        try {
            Role.valueOf(roleName.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Método para convertir string a Role
    public static Role fromString(String roleName) {
        if (roleName == null) {
            throw new IllegalArgumentException("Rol no puede ser nulo");
        }
        try {
            return Role.valueOf(roleName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Rol no válido: " + roleName);
        }
    }
}
