package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOSAGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPIRY_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FREQUENCY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TOTAL_STOCK;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PRESCRIPTIONS;

// import java.util.Collections;
// import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
// import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.prescription.Date;
import seedu.address.model.prescription.Dosage;
import seedu.address.model.prescription.Frequency;
import seedu.address.model.prescription.Name;
import seedu.address.model.prescription.Note;
import seedu.address.model.prescription.Prescription;
import seedu.address.model.prescription.Stock;
// import seedu.address.model.tag.Tag;

/**
 * Edits the details of an existing prescription in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the prescription identified "
            + "by the index number used in the displayed prescription list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_DOSAGE + "DOSAGE] "
            + "[" + PREFIX_FREQUENCY + "FREQUENCY] "
            + "[" + PREFIX_START_DATE + "START DATE] "
            + "[" + PREFIX_END_DATE + "END DATE] "
            + "[" + PREFIX_EXPIRY_DATE + "EXPIRY DATE] "
            + "[" + PREFIX_TOTAL_STOCK + "TOTAL STOCK] "
            + "[" + PREFIX_NOTE + "NOTE] \n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_DOSAGE + "2 ";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Prescription: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This prescription already exists in the address book.";

    private final Index index;
    private final EditPrescriptionDescriptor editPrescriptionDescriptor;

    /**
     * @param index of the prescription in the filtered prescription list to edit
     * @param editPrescriptionDescriptor details to edit the prescription with
     */
    public EditCommand(Index index, EditPrescriptionDescriptor editPrescriptionDescriptor) {
        requireNonNull(index);
        requireNonNull(editPrescriptionDescriptor);

        this.index = index;
        this.editPrescriptionDescriptor = new EditPrescriptionDescriptor(editPrescriptionDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Prescription> lastShownList = model.getFilteredPrescriptionList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Prescription prescriptionToEdit = lastShownList.get(index.getZeroBased());
        Prescription editedPrescription = createEditedPrescription(prescriptionToEdit, editPrescriptionDescriptor);

        if (!prescriptionToEdit.isSamePrescription(editedPrescription) && model.hasPrescription(editedPrescription)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.setPrescription(prescriptionToEdit, editedPrescription);
        model.updateFilteredPrescriptionList(PREDICATE_SHOW_ALL_PRESCRIPTIONS);
        return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, Messages.format(editedPrescription)));
    }

    /**
     * Creates and returns a {@code Prescription} with the details of {@code prescriptionToEdit}
     * edited with {@code editPrescriptionDescriptor}.
     */
    private static Prescription createEditedPrescription(Prescription prescriptionToEdit,
            EditPrescriptionDescriptor editPrescriptionDescriptor) {
        assert prescriptionToEdit != null;

        Name updatedName = editPrescriptionDescriptor.getName().orElse(prescriptionToEdit.getName());
        Dosage updatedDosage = editPrescriptionDescriptor.getDosage().orElse(prescriptionToEdit.getDosage());
        Frequency updatedFrequency = editPrescriptionDescriptor.getFrequency().orElse(
                prescriptionToEdit.getFrequency());
        Date updatedStartDate = editPrescriptionDescriptor.getStartDate().orElse(prescriptionToEdit.getStartDate());
        Date updatedEndDate = editPrescriptionDescriptor.getEndDate().orElse(prescriptionToEdit.getEndDate());
        Date updatedExpiryDate = editPrescriptionDescriptor.getExpiryDate().orElse(prescriptionToEdit.getExpiryDate());
        Stock updatedTotalStock = editPrescriptionDescriptor.getTotalStock().orElse(prescriptionToEdit.getTotalStock());
        Note updatedNote = editPrescriptionDescriptor.getNote().orElse(prescriptionToEdit.getNote());
        // Set<Tag> updatedTags = editPrescriptionDescriptor.getTags().orElse(prescriptionToEdit.getTags());

        return new Prescription(updatedName, updatedDosage, updatedFrequency, updatedStartDate,
        updatedEndDate, updatedExpiryDate, updatedTotalStock, updatedNote);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        EditCommand otherEditCommand = (EditCommand) other;
        return index.equals(otherEditCommand.index)
                && editPrescriptionDescriptor.equals(otherEditCommand.editPrescriptionDescriptor);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .add("editPrescriptionDescriptor", editPrescriptionDescriptor)
                .toString();
    }

    /**
     * Stores the details to edit the prescription with. Each non-empty field value will replace the
     * corresponding field value of the prescription.
     */
    public static class EditPrescriptionDescriptor {
        private Name name;
        private Dosage dosage;
        private Frequency frequency;
        private Date startDate;
        private Date endDate;
        private Date expiryDate;
        private Stock totalStock;
        private Note note;
        // private Set<Tag> tags;

        public EditPrescriptionDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditPrescriptionDescriptor(EditPrescriptionDescriptor toCopy) {
            setName(toCopy.name);
            setDosage(toCopy.dosage);
            setFrequency(toCopy.frequency);
            setStartDate(toCopy.startDate);
            setEndDate(toCopy.endDate);
            setExpiryDate(toCopy.expiryDate);
            setTotalStock(toCopy.totalStock);
            setNote(toCopy.note);
            // setTags(toCopy.tags);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, dosage, frequency, startDate,
                    endDate, expiryDate, totalStock, note);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setDosage(Dosage dosage) {
            this.dosage = dosage;
        }

        public Optional<Dosage> getDosage() {
            return Optional.ofNullable(dosage);
        }

        public void setFrequency(Frequency frequency) {
            this.frequency = frequency;
        }

        public Optional<Frequency> getFrequency() {
            return Optional.ofNullable(frequency);
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Optional<Date> getStartDate() {
            return Optional.ofNullable(startDate);
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public Optional<Date> getEndDate() {
            return Optional.ofNullable(endDate);
        }

        public void setExpiryDate(Date expiryDate) {
            this.expiryDate = expiryDate;
        }

        public Optional<Date> getExpiryDate() {
            return Optional.ofNullable(expiryDate);
        }

        public void setTotalStock(Stock totalStock) {
            this.totalStock = totalStock;
        }

        public Optional<Stock> getTotalStock() {
            return Optional.ofNullable(totalStock);
        }

        public void setNote(Note note) {
            this.note = note;
        }

        public Optional<Note> getNote() {
            return Optional.ofNullable(note);
        }

        // /**
        //  * Sets {@code tags} to this object's {@code tags}.
        //  * A defensive copy of {@code tags} is used internally.
        //  */
        // public void setTags(Set<Tag> tags) {
        //     this.tags = (tags != null) ? new HashSet<>(tags) : null;
        // }

        // /**
        //  * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
        //  * if modification is attempted.
        //  * Returns {@code Optional#empty()} if {@code tags} is null.
        //  */
        // public Optional<Set<Tag>> getTags() {
        //     return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        // }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditPrescriptionDescriptor)) {
                return false;
            }

            EditPrescriptionDescriptor otherEditPrescriptionDescriptor = (EditPrescriptionDescriptor) other;
            return Objects.equals(name, otherEditPrescriptionDescriptor.name)
                    && Objects.equals(dosage, otherEditPrescriptionDescriptor.dosage)
                    && Objects.equals(frequency, otherEditPrescriptionDescriptor.frequency)
                    && Objects.equals(startDate, otherEditPrescriptionDescriptor.startDate)
                    && Objects.equals(endDate, otherEditPrescriptionDescriptor.endDate)
                    && Objects.equals(expiryDate, otherEditPrescriptionDescriptor.expiryDate)
                    && Objects.equals(totalStock, otherEditPrescriptionDescriptor.totalStock)
                    && Objects.equals(note, otherEditPrescriptionDescriptor.note);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .add("name", name)
                    .add("dosage", dosage)
                    .add("frequency", frequency)
                    .add("startDate", startDate)
                    .add("endDate", endDate)
                    .add("expiryDate", expiryDate)
                    .add("totalStock", totalStock)
                    .add("note", note)
                    .toString();
        }
    }
}
