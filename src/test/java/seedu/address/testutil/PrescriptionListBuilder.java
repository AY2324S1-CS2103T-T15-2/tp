package seedu.address.testutil;

import seedu.address.model.PrescriptionList;
import seedu.address.model.prescription.Prescription;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code PrescriptionList ab = new PrescriptionListBuilder().withPrescription("John", "Doe").build();}
 */
public class PrescriptionListBuilder {

    private PrescriptionList addressBook;

    public PrescriptionListBuilder() {
        addressBook = new PrescriptionList();
    }

    public PrescriptionListBuilder(PrescriptionList addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Prescription} to the {@code PrescriptionList} that we are building.
     */
    public PrescriptionListBuilder withPrescription(Prescription prescription) {
        addressBook.addPrescription(prescription);
        return this;
    }

    public PrescriptionList build() {
        return addressBook;
    }
}
