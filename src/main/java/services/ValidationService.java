package services;

import models.Inventory;
import org.testng.Assert;

public class ValidationService {


    public void validateInventory(Inventory updatedInventory, Inventory originalInventory, String orderStatus, String validation) {
        switch (orderStatus + " " + validation) {
            case "approved increase" -> Assert.assertTrue(updatedInventory.getApproved() > originalInventory.getApproved());
            case "placed increase" -> Assert.assertTrue(updatedInventory.getPlaced() > originalInventory.getPlaced());
            case "delivered increase" -> Assert.assertTrue(updatedInventory.getDelivered() > originalInventory.getDelivered());
            case "approved decrease" -> Assert.assertTrue(updatedInventory.getApproved() < originalInventory.getApproved());
            case "placed decrease" -> Assert.assertTrue(updatedInventory.getPlaced() < originalInventory.getPlaced());
            case "delivered decrease" -> Assert.assertTrue(updatedInventory.getDelivered() < originalInventory.getDelivered());
            default -> throw new RuntimeException("Not a valid order status");
        }

    }
}
