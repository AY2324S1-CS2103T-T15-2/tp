// package seedu.address.storage;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static seedu.address.testutil.Assert.assertThrows;

// import java.nio.file.Path;
// import java.nio.file.Paths;

// import org.junit.jupiter.api.Test;

// import seedu.address.commons.exceptions.IllegalValueException;
// import seedu.address.commons.util.JsonUtil;
// import seedu.address.model.PrescriptionList;
// import seedu.address.testutil.TypicalPrescriptions;

// public class JsonSerializablePrescriptionListTest {

//     private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializablePrescriptionListTest");
//     private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPrescriptionsPrescriptionList.json");
//     private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPrescriptionPrescriptionList.json");
//     private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePrescriptionPrescriptionList.json");

//     @Test
//     public void toModelType_typicalPrescriptionsFile_success() throws Exception {
//         JsonSerializablePrescriptionList dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
//                 JsonSerializablePrescriptionList.class).get();
//         PrescriptionList addressBookFromFile = dataFromFile.toModelType();
//         PrescriptionList typicalPrescriptionsPrescriptionList = TypicalPrescriptions.getTypicalPrescriptionList();
//         assertEquals(addressBookFromFile, typicalPrescriptionsPrescriptionList);
//     }

//     @Test
//     public void toModelType_invalidPrescriptionFile_throwsIllegalValueException() throws Exception {
//         JsonSerializablePrescriptionList dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
//                 JsonSerializablePrescriptionList.class).get();
//         assertThrows(IllegalValueException.class, dataFromFile::toModelType);
//     }

//     @Test
//     public void toModelType_duplicatePrescriptions_throwsIllegalValueException() throws Exception {
//         JsonSerializablePrescriptionList dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
//                 JsonSerializablePrescriptionList.class).get();
//         assertThrows(IllegalValueException.class, JsonSerializablePrescriptionList.MESSAGE_DUPLICATE_PERSON,
//                 dataFromFile::toModelType);
//     }

// }
