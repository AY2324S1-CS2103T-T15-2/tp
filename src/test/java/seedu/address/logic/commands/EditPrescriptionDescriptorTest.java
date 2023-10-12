// package seedu.address.logic.commands;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
// import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

// import org.junit.jupiter.api.Test;

// import seedu.address.logic.commands.EditCommand.EditPrescriptionDescriptor;
// import seedu.address.testutil.EditPrescriptionDescriptorBuilder;

// public class EditPrescriptionDescriptorTest {

//     @Test
//     public void equals() {
//         // same values -> returns true
//         EditPrescriptionDescriptor descriptorWithSameValues = new EditPrescriptionDescriptor(DESC_AMY);
//         assertTrue(DESC_AMY.equals(descriptorWithSameValues));

//         // same object -> returns true
//         assertTrue(DESC_AMY.equals(DESC_AMY));

//         // null -> returns false
//         assertFalse(DESC_AMY.equals(null));

//         // different types -> returns false
//         assertFalse(DESC_AMY.equals(5));

//         // different values -> returns false
//         assertFalse(DESC_AMY.equals(DESC_BOB));

//         // different name -> returns false
//         EditPrescriptionDescriptor editedAmy = new EditPrescriptionDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
//         assertFalse(DESC_AMY.equals(editedAmy));

//         // different phone -> returns false
//         editedAmy = new EditPrescriptionDescriptorBuilder(DESC_AMY).withPhone(VALID_PHONE_BOB).build();
//         assertFalse(DESC_AMY.equals(editedAmy));

//         // different email -> returns false
//         editedAmy = new EditPrescriptionDescriptorBuilder(DESC_AMY).withEmail(VALID_EMAIL_BOB).build();
//         assertFalse(DESC_AMY.equals(editedAmy));

//         // different address -> returns false
//         editedAmy = new EditPrescriptionDescriptorBuilder(DESC_AMY).withAddress(VALID_ADDRESS_BOB).build();
//         assertFalse(DESC_AMY.equals(editedAmy));

//         // different tags -> returns false
//         editedAmy = new EditPrescriptionDescriptorBuilder(DESC_AMY).withTags(VALID_TAG_HUSBAND).build();
//         assertFalse(DESC_AMY.equals(editedAmy));
//     }

//     @Test
//     public void toStringMethod() {
//         EditPrescriptionDescriptor editPrescriptionDescriptor = new EditPrescriptionDescriptor();
//         String expected = EditPrescriptionDescriptor.class.getCanonicalName() + "{name="
//                 + editPrescriptionDescriptor.getName().orElse(null) + ", phone="
//                 + editPrescriptionDescriptor.getPhone().orElse(null) + ", email="
//                 + editPrescriptionDescriptor.getEmail().orElse(null) + ", address="
//                 + editPrescriptionDescriptor.getAddress().orElse(null) + ", tags="
//                 + editPrescriptionDescriptor.getTags().orElse(null) + "}";
//         assertEquals(expected, editPrescriptionDescriptor.toString());
//     }
// }
