// package seedu.address.testutil;

// import java.util.HashSet;
// import java.util.Set;

// import seedu.address.model.prescription.Address;
// import seedu.address.model.prescription.Email;
// import seedu.address.model.prescription.Name;
// import seedu.address.model.prescription.Prescription;
// import seedu.address.model.prescription.Phone;
// import seedu.address.model.tag.Tag;
// import seedu.address.model.util.SampleDataUtil;

// /**
//  * A utility class to help with building Prescription objects.
//  */
// public class PrescriptionBuilder {

//     public static final String DEFAULT_NAME = "Amy Bee";
//     public static final String DEFAULT_PHONE = "85355255";
//     public static final String DEFAULT_EMAIL = "amy@gmail.com";
//     public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

//     private Name name;
//     private Phone phone;
//     private Email email;
//     private Address address;
//     private Set<Tag> tags;

//     /**
//      * Creates a {@code PrescriptionBuilder} with the default details.
//      */
//     public PrescriptionBuilder() {
//         name = new Name(DEFAULT_NAME);
//         phone = new Phone(DEFAULT_PHONE);
//         email = new Email(DEFAULT_EMAIL);
//         address = new Address(DEFAULT_ADDRESS);
//         tags = new HashSet<>();
//     }

//     /**
//      * Initializes the PrescriptionBuilder with the data of {@code prescriptionToCopy}.
//      */
//     public PrescriptionBuilder(Prescription prescriptionToCopy) {
//         name = prescriptionToCopy.getName();
//         phone = prescriptionToCopy.getPhone();
//         email = prescriptionToCopy.getEmail();
//         address = prescriptionToCopy.getAddress();
//         tags = new HashSet<>(prescriptionToCopy.getTags());
//     }

//     /**
//      * Sets the {@code Name} of the {@code Prescription} that we are building.
//      */
//     public PrescriptionBuilder withName(String name) {
//         this.name = new Name(name);
//         return this;
//     }

//     /**
//      * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Prescription} that we are building.
//      */
//     public PrescriptionBuilder withTags(String ... tags) {
//         this.tags = SampleDataUtil.getTagSet(tags);
//         return this;
//     }

//     /**
//      * Sets the {@code Address} of the {@code Prescription} that we are building.
//      */
//     public PrescriptionBuilder withAddress(String address) {
//         this.address = new Address(address);
//         return this;
//     }

//     /**
//      * Sets the {@code Phone} of the {@code Prescription} that we are building.
//      */
//     public PrescriptionBuilder withPhone(String phone) {
//         this.phone = new Phone(phone);
//         return this;
//     }

//     /**
//      * Sets the {@code Email} of the {@code Prescription} that we are building.
//      */
//     public PrescriptionBuilder withEmail(String email) {
//         this.email = new Email(email);
//         return this;
//     }

//     public Prescription build() {
//         return new Prescription(name, phone, email, address, tags);
//     }

// }
