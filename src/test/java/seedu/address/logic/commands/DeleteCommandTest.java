// package seedu.address.logic.commands;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
// import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
// import static seedu.address.logic.commands.CommandTestUtil.showPrescriptionAtIndex;
// import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
// import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
// import static seedu.address.testutil.TypicalPrescriptions.getTypicalPrescriptionList;

// import org.junit.jupiter.api.Test;

// import seedu.address.commons.core.index.Index;
// import seedu.address.logic.Messages;
// import seedu.address.model.Model;
// import seedu.address.model.ModelManager;
// import seedu.address.model.UserPrefs;
// import seedu.address.model.prescription.Prescription;

// /**
//  * Contains integration tests (interaction with the Model) and unit tests for
//  * {@code DeleteCommand}.
//  */
// public class DeleteCommandTest {

//     private Model model = new ModelManager(getTypicalPrescriptionList(), new UserPrefs());

//     @Test
//     public void execute_validIndexUnfilteredList_success() {
//         Prescription prescriptionToDelete = model.getFilteredPrescriptionList().get(INDEX_FIRST_PERSON.getZeroBased());
//         DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_PERSON);

//         String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS,
//                 Messages.format(prescriptionToDelete));

//         ModelManager expectedModel = new ModelManager(model.getPrescriptionList(), new UserPrefs());
//         expectedModel.deletePrescription(prescriptionToDelete);

//         assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
//     }

//     @Test
//     public void execute_invalidIndexUnfilteredList_throwsCommandException() {
//         Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPrescriptionList().size() + 1);
//         DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

//         assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
//     }

//     @Test
//     public void execute_validIndexFilteredList_success() {
//         showPrescriptionAtIndex(model, INDEX_FIRST_PERSON);

//         Prescription prescriptionToDelete = model.getFilteredPrescriptionList().get(INDEX_FIRST_PERSON.getZeroBased());
//         DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_PERSON);

//         String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS,
//                 Messages.format(prescriptionToDelete));

//         Model expectedModel = new ModelManager(model.getPrescriptionList(), new UserPrefs());
//         expectedModel.deletePrescription(prescriptionToDelete);
//         showNoPrescription(expectedModel);

//         assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
//     }

//     @Test
//     public void execute_invalidIndexFilteredList_throwsCommandException() {
//         showPrescriptionAtIndex(model, INDEX_FIRST_PERSON);

//         Index outOfBoundIndex = INDEX_SECOND_PERSON;
//         // ensures that outOfBoundIndex is still in bounds of prescription list list
//         assertTrue(outOfBoundIndex.getZeroBased() < model.getPrescriptionList().getPrescriptionList().size());

//         DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

//         assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
//     }

//     @Test
//     public void equals() {
//         DeleteCommand deleteFirstCommand = new DeleteCommand(INDEX_FIRST_PERSON);
//         DeleteCommand deleteSecondCommand = new DeleteCommand(INDEX_SECOND_PERSON);

//         // same object -> returns true
//         assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

//         // same values -> returns true
//         DeleteCommand deleteFirstCommandCopy = new DeleteCommand(INDEX_FIRST_PERSON);
//         assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

//         // different types -> returns false
//         assertFalse(deleteFirstCommand.equals(1));

//         // null -> returns false
//         assertFalse(deleteFirstCommand.equals(null));

//         // different prescription -> returns false
//         assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
//     }

//     @Test
//     public void toStringMethod() {
//         Index targetIndex = Index.fromOneBased(1);
//         DeleteCommand deleteCommand = new DeleteCommand(targetIndex);
//         String expected = DeleteCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
//         assertEquals(expected, deleteCommand.toString());
//     }

//     /**
//      * Updates {@code model}'s filtered list to show no one.
//      */
//     private void showNoPrescription(Model model) {
//         model.updateFilteredPrescriptionList(p -> false);

//         assertTrue(model.getFilteredPrescriptionList().isEmpty());
//     }
// }
