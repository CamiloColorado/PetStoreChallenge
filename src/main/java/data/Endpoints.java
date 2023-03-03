package data;

public abstract class Endpoints {

    /**
     * Pet
     */

    public static final String PET = "/pet";

    public static final String PET_BY_STATUS = "/pet/findByStatus";

    public static final String PET_BY_TAGS = "/pet/findByTags";

    public static final String PET_BY_ID = "/pet/{petId}";

    public static final String PET_IMAGE = "/pet/{petId}/uploadImage";

    /**
     * Store
     */

    public static final String STORE_INVENTORY = "/store/inventory";

    public static final String STORE_ORDER = "/store/order";

    public static final String STORE_ORDER_BY_ID = "/store/order/{orderId}";

    /**
     * User
     */

    public static final String USER = "/user";

    public static final String USER_LIST = "/user/createWithList";

    public static final String USER_LOGIN = "/user/login";

    public static final String USER_LOGOUT = "/user/logout";

    public static final String USER_BY_NAME = "/user/{username}";

}
