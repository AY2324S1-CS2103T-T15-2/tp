// package seedu.address.model.prescription;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
// import static seedu.address.testutil.Assert.assertThrows;
// import static seedu.address.testutil.TypicalPrescriptions.ALICE;
// import static seedu.address.testutil.TypicalPrescriptions.BOB;

// import org.junit.jupiter.api.Test;

// import seedu.address.testutil.PrescriptionBuilder;

// public class PrescriptionTest {

//     @Test
//     public void asObservableList_modifyList_throwsUnsupportedOperationException() {
//         Prescription prescription = new PrescriptionBuilder().build();
//         assertThrows(UnsupportedOperationException.class, () -> prescription.getTags().remove(0));
//     }

//     @Test
//     public void isSamePrescription() {
//         // same object -> returns true
//         assertTrue(ALICE.isSamePrescription(ALICE));

//         // null -> returns false
//         assertFalse(ALICE.isSamePrescription(null));

//         // same name, all other attributes different -> returns true
//         Prescription editedAlice = new PrescriptionBuilder(ALICE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
//                 .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND).build();
//         assertTrue(ALICE.isSamePrescription(editedAlice));

//         // different name, all other attributes same -> returns false
//         editedAlice = new PrescriptionBuilder(ALICE).withName(VALID_NAME_BOB).build();
//         assertFalse(ALICE.isSamePrescription(editedAlice));

//         // name differs in case, all other attributes same -> returns false
//         Prescription editedBob = new PrescriptionBuilder(BOB).withName(VALID_NAME_BOB.toLowerCase()).build();
//         assertFalse(BOB.isSamePrescription(editedBob));

//         // name has trailing spaces, all other attributes same -> returns false
//         String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
//         editedBob = new PrescriptionBuilder(BOB).withName(nameWithTrailingSpaces).build();
//         assertFalse(BOB.isSamePrescription(editedBob));
//     }

//     @Test
//     public void equals() {
//         // same values -> returns true
//         Prescription aliceCopy = new PrescriptionBuilder(ALICE).build();
//         assertTrue(ALICE.equals(aliceCopy));

//         // same object -> returns true
//         assertTrue(ALICE.equals(ALICE));

//         // null -> returns false
//         assertFalse(ALICE.equals(null));

//         // different type -> returns false
//         assertFalse(ALICE.equals(5));

//         // different prescription -> returns false
//         assertFalse(ALICE.equals(BOB));

//         // different name -> returns false
//         Prescription editedAlice = new PrescriptionBuilder(ALICE).withName(VALID_NAME_BOB).build();
//         assertFalse(ALICE.equals(editedAlice));

//         // different phone -> returns false
//         editedAlice = new PrescriptionBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
//         assertFalse(ALICE.equals(editedAlice));

//         // different email -> returns false
//         editedAlice = new PrescriptionBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
//         assertFalse(ALICE.equals(editedAlice));

//         // different address -> returns false
//         editedAlice = new PrescriptionBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
//         assertFalse(ALICE.equals(editedAlice));

//         // different tags -> returns false
//         editedAlice = new PrescriptionBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
//         assertFalse(ALICE.equals(editedAlice));
//     }

//     @Test
//     public void toStringMethod() {
//         String expected = Prescription.class.getCanonicalName() + "{name=" + ALICE.getName() + ", phone=" + ALICE.getPhone()
//                 + ", email=" + ALICE.getEmail() + ", address=" + ALICE.getAddress() + ", tags=" + ALICE.getTags() + "}";
//         assertEquals(expected, ALICE.toString());
//     }
// }
