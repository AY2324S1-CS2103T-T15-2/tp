package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.prescription.Prescription;

/**
 * Represents the in-memory model of the prescription list data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final PrescriptionList prescriptionList;
    private final UserPrefs userPrefs;
    private final FilteredList<Prescription> filteredPrescriptions;

    /**
     * Initializes a ModelManager with the given prescriptionList and userPrefs.
     */
    public ModelManager(ReadOnlyPrescriptionList prescriptionList, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(prescriptionList, userPrefs);

        logger.fine("Initializing with prescription list: " + prescriptionList + " and user prefs " + userPrefs);

        this.prescriptionList = new PrescriptionList(prescriptionList);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPrescriptions = new FilteredList<>(this.prescriptionList.getPrescriptionList());
    }

    public ModelManager() {
        this(new PrescriptionList(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getPrescriptionListFilePath() {
        return userPrefs.getPrescriptionListFilePath();
    }

    @Override
    public void setPrescriptionListFilePath(Path prescriptionListFilePath) {
        requireNonNull(prescriptionListFilePath);
        userPrefs.setPrescriptionListFilePath(prescriptionListFilePath);
    }

    //=========== PrescriptionList ================================================================================

    @Override
    public void setPrescriptionList(ReadOnlyPrescriptionList prescriptionList) {
        this.prescriptionList.resetData(prescriptionList);
    }

    @Override
    public ReadOnlyPrescriptionList getPrescriptionList() {
        return prescriptionList;
    }

    @Override
    public boolean hasPrescription(Prescription prescription) {
        requireNonNull(prescription);
        return prescriptionList.hasPrescription(prescription);
    }

    @Override
    public void deletePrescription(Prescription target) {
        prescriptionList.removePrescription(target);
    }

    @Override
    public void addPrescription(Prescription prescription) {
        prescriptionList.addPrescription(prescription);
        updateFilteredPrescriptionList(PREDICATE_SHOW_ALL_PRESCRIPTIONS);
    }

    @Override
    public void setPrescription(Prescription target, Prescription editedPrescription) {
        requireAllNonNull(target, editedPrescription);

        prescriptionList.setPrescription(target, editedPrescription);
    }

    //=========== Filtered Prescription List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Prescription} backed by the internal list of
     * {@code versionedPrescriptionList}
     */
    @Override
    public ObservableList<Prescription> getFilteredPrescriptionList() {
        return filteredPrescriptions;
    }

    @Override
    public void updateFilteredPrescriptionList(Predicate<Prescription> predicate) {
        requireNonNull(predicate);
        filteredPrescriptions.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModelManager)) {
            return false;
        }

        ModelManager otherModelManager = (ModelManager) other;
        return prescriptionList.equals(otherModelManager.prescriptionList)
                && userPrefs.equals(otherModelManager.userPrefs)
                && filteredPrescriptions.equals(otherModelManager.filteredPrescriptions);
    }

}
