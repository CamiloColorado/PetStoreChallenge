package data;

import com.github.javafaker.Faker;
import models.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DataProvider {

    private final Faker faker = new Faker(new Locale("en-en"));

    public Pet generatePet() {
        Pet pet = new Pet();
        pet.setId(faker.number().numberBetween(1, 99));
        pet.setName(faker.pokemon().name());
        pet.setCategory(generateCategory());
        pet.setPhotoUrls(generatePhotoUrls());
        pet.setTags(generateTags());
        pet.setStatus(StatusEnum.available);
        return pet;
    }

    private Category generateCategory() {
        Category category = new Category();
        category.setId(1);
        category.setName(faker.gameOfThrones().house());
        return category;
    }

    private List<String> generatePhotoUrls() {
        List<String> urls = new ArrayList<>();
        urls.add("Image");
        return urls;
    }

    private List<Tag> generateTags() {
        List<Tag> tags = new ArrayList<>();
        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("Test");
        tags.add(tag);
        return tags;
    }

    public Order generateOrder() {
        Order order = new Order();
        order.setId(faker.number().numberBetween(1, 99));
        order.setPetId(faker.number().numberBetween(1, 99));
        order.setQuantity(faker.number().numberBetween(1, 99));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = faker.date().future(24, TimeUnit.HOURS);
        order.setShipDate(simpleDateFormat.format(date));
        order.setStatus(OrderStatusEnum.approved);
        order.setComplete(false);
        return order;
    }

    public User generateUser() {
        User user = new User();
        user.setId(faker.number().numberBetween(1, 99));
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(user.getFirstName() + "." + user.getLastName() + "@email.com");
        user.setPassword(faker.numerify("##########"));
        user.setPhone(faker.phoneNumber().cellPhone());
        user.setUserStatus(1);
        return user;
    }

    public User updateUserField(User user, String field) {
        switch (field) {
            case "username" -> user.setUsername("WrongUser");
            case "password" -> user.setPassword("WrongPassword");
            case "username and password" -> {
                user.setUsername("WrongUser");
                user.setPassword("WrongPassword");
            }
            default -> throw new RuntimeException("Not a valid user field");
        }
        return user;
    }

    public Order updateOrderField(Order order, String field, String fieldValue) {
        switch (field) {
            case "orderId" -> order.setId(Integer.parseInt(fieldValue));
            case "status" -> order.setStatus(OrderStatusEnum.valueOf(fieldValue));
            default -> throw new RuntimeException("Not a valid order field");
        }
        return order;
    }

    public Pet updatePetField(Pet pet, String field) {
        switch (field) {
            case "petId" -> pet.setId(123456789);
            case "name" -> pet.setName(null);
            default -> throw new RuntimeException("Not a valid pet field");
        }
        return pet;
    }
}
