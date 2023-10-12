// package seedu.address.testutil;

// import java.util.Set;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// import seedu.address.logic.commands.EditCommand.EditPrescriptionDescriptor;
// import seedu.address.model.prescription.Address;
// import seedu.address.model.prescription.Email;
// import seedu.address.model.prescription.Name;
// import seedu.address.model.prescription.Prescription;
// import seedu.address.model.prescription.Phone;
// import seedu.address.model.tag.Tag;

// /**
//  * A utility class to help with building EditPrescriptionDescriptor objects.
//  */
// public class EditPrescriptionDescriptorBuilder {

//     private EditPrescriptionDescriptor descriptor;

//     public EditPrescriptionDescriptorBuilder() {
//         descriptor = new EditPrescriptionDescriptor();
//     }

//     public EditPrescriptionDescriptorBuilder(EditPrescriptionDescriptor descriptor) {
//         this.descriptor = new EditPrescriptionDescriptor(descriptor);
//     }

//     /**
//      * Returns an {@code EditPrescriptionDescriptor} with fields containing {@code prescription}'s details
//      */
//     public EditPrescriptionDescriptorBuilder(Prescription prescription) {
//         descriptor = new EditPrescriptionDescriptor();
//         descriptor.setName(prescription.getName());
//         descriptor.setPhone(prescription.getPhone());
//         descriptor.setEmail(prescription.getEmail());
//         descriptor.setAddress(prescription.getAddress());
//         descriptor.setTags(prescription.getTags());
//     }

//     /**
//      * Sets the {@code Name} of the {@code EditPrescriptionDescriptor} that we are building.
//      */
//     public EditPrescriptionDescriptorBuilder withName(String name) {
//         descriptor.setName(new Name(name));
//         return this;
//     }

//     /**
//      * Sets the {@code Phone} of the {@code EditPrescriptionDescriptor} that we are building.
//      */
//     public EditPrescriptionDescriptorBuilder withPhone(String phone) {
//         descriptor.setPhone(new Phone(phone));
//         return this;
//     }

//     /**
//      * Sets the {@code Email} of the {@code EditPrescriptionDescriptor} that we are building.
//      */
//     public EditPrescriptionDescriptorBuilder withEmail(String email) {
//         descriptor.setEmail(new Email(email));
//         return this;
//     }

//     /**
//      * Sets the {@code Address} of the {@code EditPrescriptionDescriptor} that we are building.
//      */
//     public EditPrescriptionDescriptorBuilder withAddress(String address) {
//         descriptor.setAddress(new Address(address));
//         return this;
//     }

//     /**
//      * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPrescriptionDescriptor}
//      * that we are building.
//      */
//     public EditPrescriptionDescriptorBuilder withTags(String... tags) {
//         Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
//         descriptor.setTags(tagSet);
//         return this;
//     }

//     public EditPrescriptionDescriptor build() {
//         return descriptor;
//     }
// }
