// package seedu.address.model.prescription;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
// import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
// import static seedu.address.testutil.Assert.assertThrows;
// import static seedu.address.testutil.TypicalPrescriptions.ALICE;
// import static seedu.address.testutil.TypicalPrescriptions.BOB;

// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

// import org.junit.jupiter.api.Test;

// import seedu.address.model.prescription.exceptions.DuplicatePrescriptionException;
// import seedu.address.model.prescription.exceptions.PrescriptionNotFoundException;
// import seedu.address.testutil.PrescriptionBuilder;

// public class UniquePrescriptionListTest {

//     private final UniquePrescriptionList uniquePrescriptionList = new UniquePrescriptionList();

//     @Test
//     public void contains_nullPrescription_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> uniquePrescriptionList.contains(null));
//     }

//     @Test
//     public void contains_prescriptionNotInList_returnsFalse() {
//         assertFalse(uniquePrescriptionList.contains(ALICE));
//     }

//     @Test
//     public void contains_prescriptionInList_returnsTrue() {
//         uniquePrescriptionList.add(ALICE);
//         assertTrue(uniquePrescriptionList.contains(ALICE));
//     }

//     @Test
//     public void contains_prescriptionWithSameIdentityFieldsInList_returnsTrue() {
//         uniquePrescriptionList.add(ALICE);
//         Prescription editedAlice = new PrescriptionBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
//                 .build();
//         assertTrue(uniquePrescriptionList.contains(editedAlice));
//     }

//     @Test
//     public void add_nullPrescription_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> uniquePrescriptionList.add(null));
//     }

//     @Test
//     public void add_duplicatePrescription_throwsDuplicatePrescriptionException() {
//         uniquePrescriptionList.add(ALICE);
//         assertThrows(DuplicatePrescriptionException.class, () -> uniquePrescriptionList.add(ALICE));
//     }

//     @Test
//     public void setPrescription_nullTargetPrescription_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> uniquePrescriptionList.setPrescription(null, ALICE));
//     }

//     @Test
//     public void setPrescription_nullEditedPrescription_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> uniquePrescriptionList.setPrescription(ALICE, null));
//     }

//     @Test
//     public void setPrescription_targetPrescriptionNotInList_throwsPrescriptionNotFoundException() {
//         assertThrows(PrescriptionNotFoundException.class, () -> uniquePrescriptionList.setPrescription(ALICE, ALICE));
//     }

//     @Test
//     public void setPrescription_editedPrescriptionIsSamePrescription_success() {
//         uniquePrescriptionList.add(ALICE);
//         uniquePrescriptionList.setPrescription(ALICE, ALICE);
//         UniquePrescriptionList expectedUniquePrescriptionList = new UniquePrescriptionList();
//         expectedUniquePrescriptionList.add(ALICE);
//         assertEquals(expectedUniquePrescriptionList, uniquePrescriptionList);
//     }

//     @Test
//     public void setPrescription_editedPrescriptionHasSameIdentity_success() {
//         uniquePrescriptionList.add(ALICE);
//         Prescription editedAlice = new PrescriptionBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
//                 .build();
//         uniquePrescriptionList.setPrescription(ALICE, editedAlice);
//         UniquePrescriptionList expectedUniquePrescriptionList = new UniquePrescriptionList();
//         expectedUniquePrescriptionList.add(editedAlice);
//         assertEquals(expectedUniquePrescriptionList, uniquePrescriptionList);
//     }

//     @Test
//     public void setPrescription_editedPrescriptionHasDifferentIdentity_success() {
//         uniquePrescriptionList.add(ALICE);
//         uniquePrescriptionList.setPrescription(ALICE, BOB);
//         UniquePrescriptionList expectedUniquePrescriptionList = new UniquePrescriptionList();
//         expectedUniquePrescriptionList.add(BOB);
//         assertEquals(expectedUniquePrescriptionList, uniquePrescriptionList);
//     }

//     @Test
//     public void setPrescription_editedPrescriptionHasNonUniqueIdentity_throwsDuplicatePrescriptionException() {
//         uniquePrescriptionList.add(ALICE);
//         uniquePrescriptionList.add(BOB);
//         assertThrows(DuplicatePrescriptionException.class, () -> uniquePrescriptionList.setPrescription(ALICE, BOB));
//     }

//     @Test
//     public void remove_nullPrescription_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> uniquePrescriptionList.remove(null));
//     }

//     @Test
//     public void remove_prescriptionDoesNotExist_throwsPrescriptionNotFoundException() {
//         assertThrows(PrescriptionNotFoundException.class, () -> uniquePrescriptionList.remove(ALICE));
//     }

//     @Test
//     public void remove_existingPrescription_removesPrescription() {
//         uniquePrescriptionList.add(ALICE);
//         uniquePrescriptionList.remove(ALICE);
//         UniquePrescriptionList expectedUniquePrescriptionList = new UniquePrescriptionList();
//         assertEquals(expectedUniquePrescriptionList, uniquePrescriptionList);
//     }

//     @Test
//     public void setPrescriptions_nullUniquePrescriptionList_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> uniquePrescriptionList.setPrescriptions((UniquePrescriptionList) null));
//     }

//     @Test
//     public void setPrescriptions_uniquePrescriptionList_replacesOwnListWithProvidedUniquePrescriptionList() {
//         uniquePrescriptionList.add(ALICE);
//         UniquePrescriptionList expectedUniquePrescriptionList = new UniquePrescriptionList();
//         expectedUniquePrescriptionList.add(BOB);
//         uniquePrescriptionList.setPrescriptions(expectedUniquePrescriptionList);
//         assertEquals(expectedUniquePrescriptionList, uniquePrescriptionList);
//     }

//     @Test
//     public void setPrescriptions_nullList_throwsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> uniquePrescriptionList.setPrescriptions((List<Prescription>) null));
//     }

//     @Test
//     public void setPrescriptions_list_replacesOwnListWithProvidedList() {
//         uniquePrescriptionList.add(ALICE);
//         List<Prescription> prescriptionList = Collections.singletonList(BOB);
//         uniquePrescriptionList.setPrescriptions(prescriptionList);
//         UniquePrescriptionList expectedUniquePrescriptionList = new UniquePrescriptionList();
//         expectedUniquePrescriptionList.add(BOB);
//         assertEquals(expectedUniquePrescriptionList, uniquePrescriptionList);
//     }

//     @Test
//     public void setPrescriptions_listWithDuplicatePrescriptions_throwsDuplicatePrescriptionException() {
//         List<Prescription> listWithDuplicatePrescriptions = Arrays.asList(ALICE, ALICE);
//         assertThrows(DuplicatePrescriptionException.class, () -> uniquePrescriptionList.setPrescriptions(listWithDuplicatePrescriptions));
//     }

//     @Test
//     public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
//         assertThrows(UnsupportedOperationException.class, ()
//             -> uniquePrescriptionList.asUnmodifiableObservableList().remove(0));
//     }

//     @Test
//     public void toStringMethod() {
//         assertEquals(uniquePrescriptionList.asUnmodifiableObservableList().toString(), uniquePrescriptionList.toString());
//     }
// }
