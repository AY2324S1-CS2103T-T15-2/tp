// package seedu.address.model;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
// import static seedu.address.testutil.Assert.assertThrows;
// import static seedu.address.testutil.TypicalPrescriptions.ALICE;
// import static seedu.address.testutil.TypicalPrescriptions.getTypicalPrescriptionList;

// import java.util.Arrays;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.List;

// import org.junit.jupiter.api.Test;

// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import seedu.address.model.prescription.Prescription;
// import seedu.address.model.prescription.exceptions.DuplicatePrescriptionException;
// import seedu.address.testutil.PrescriptionBuilder;

// public class PrescriptionListTest {

//     private final PrescriptionList addressBook = new PrescriptionList();

//     @Test
//     public void constructor() {
//         assertEquals(Collections.emptyList(), addressBook.getPrescriptionList());
//     }

//     @Test
//     public void resetData_null_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> addressBook.resetData(null));
//     }

//     @Test
//     public void resetData_withValidReadOnlyPrescriptionList_replacesData() {
//         PrescriptionList newData = getTypicalPrescriptionList();
//         addressBook.resetData(newData);
//         assertEquals(newData, addressBook);
//     }

//     @Test
//     public void resetData_withDuplicatePrescriptions_throwsDuplicatePrescriptionException() {
//         // Two prescriptions with the same identity fields
//         Prescription editedAlice = new PrescriptionBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
//                 .build();
//         List<Prescription> newPrescriptions = Arrays.asList(ALICE, editedAlice);
//         PrescriptionListStub newData = new PrescriptionListStub(newPrescriptions);

//         assertThrows(DuplicatePrescriptionException.class, () -> addressBook.resetData(newData));
//     }

//     @Test
//     public void hasPrescription_nullPrescription_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> addressBook.hasPrescription(null));
//     }

//     @Test
//     public void hasPrescription_prescriptionNotInPrescriptionList_returnsFalse() {
//         assertFalse(addressBook.hasPrescription(ALICE));
//     }

//     @Test
//     public void hasPrescription_prescriptionInPrescriptionList_returnsTrue() {
//         addressBook.addPrescription(ALICE);
//         assertTrue(addressBook.hasPrescription(ALICE));
//     }

//     @Test
//     public void hasPrescription_prescriptionWithSameIdentityFieldsInPrescriptionList_returnsTrue() {
//         addressBook.addPrescription(ALICE);
//         Prescription editedAlice = new PrescriptionBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
//                 .build();
//         assertTrue(addressBook.hasPrescription(editedAlice));
//     }

//     @Test
//     public void getPrescriptionList_modifyList_throwsUnsupportedOperationException() {
//         assertThrows(UnsupportedOperationException.class, () -> addressBook.getPrescriptionList().remove(0));
//     }

//     @Test
//     public void toStringMethod() {
//         String expected = PrescriptionList.class.getCanonicalName() + "{prescriptions=" + addressBook.getPrescriptionList() + "}";
//         assertEquals(expected, addressBook.toString());
//     }

//     /**
//      * A stub ReadOnlyPrescriptionList whose prescriptions list can violate interface constraints.
//      */
//     private static class PrescriptionListStub implements ReadOnlyPrescriptionList {
//         private final ObservableList<Prescription> prescriptions = FXCollections.observableArrayList();

//         PrescriptionListStub(Collection<Prescription> prescriptions) {
//             this.prescriptions.setAll(prescriptions);
//         }

//         @Override
//         public ObservableList<Prescription> getPrescriptionList() {
//             return prescriptions;
//         }
//     }

// }
