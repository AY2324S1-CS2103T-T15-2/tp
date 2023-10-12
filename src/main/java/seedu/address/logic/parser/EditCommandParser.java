package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOSAGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPIRY_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FREQUENCY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TOTAL_STOCK;

// import java.util.Collection;
// import java.util.Collections;
// import java.util.Optional;
// import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditPrescriptionDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
// import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_DOSAGE, PREFIX_FREQUENCY,
                    PREFIX_START_DATE, PREFIX_END_DATE, PREFIX_EXPIRY_DATE, PREFIX_TOTAL_STOCK, PREFIX_NOTE);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE), pe);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_DOSAGE, PREFIX_FREQUENCY,
            PREFIX_START_DATE, PREFIX_END_DATE, PREFIX_EXPIRY_DATE, PREFIX_TOTAL_STOCK, PREFIX_NOTE);

        EditPrescriptionDescriptor editPrescriptionDescriptor = new EditPrescriptionDescriptor();

        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            editPrescriptionDescriptor.setName(ParserUtil.parseName(
                argMultimap.getValue(PREFIX_NAME).get()));
        }
        if (argMultimap.getValue(PREFIX_DOSAGE).isPresent()) {
            editPrescriptionDescriptor.setDosage(ParserUtil.parseDosage(
                argMultimap.getValue(PREFIX_DOSAGE).get()));
        }
        if (argMultimap.getValue(PREFIX_FREQUENCY).isPresent()) {
            editPrescriptionDescriptor.setFrequency(ParserUtil.parseFrequency(
                argMultimap.getValue(PREFIX_FREQUENCY).get()));
        }
        if (argMultimap.getValue(PREFIX_START_DATE).isPresent()) {
            editPrescriptionDescriptor.setStartDate(ParserUtil.parseStartDate(
                argMultimap.getValue(PREFIX_START_DATE).get()));
        }
        if (argMultimap.getValue(PREFIX_END_DATE).isPresent()) {
            editPrescriptionDescriptor.setEndDate(ParserUtil.parseEndDate(
                argMultimap.getValue(PREFIX_END_DATE).get()));
        }
        if (argMultimap.getValue(PREFIX_EXPIRY_DATE).isPresent()) {
            editPrescriptionDescriptor.setExpiryDate(ParserUtil.parseExpiryDate(
                argMultimap.getValue(PREFIX_EXPIRY_DATE).get()));
        }
        if (argMultimap.getValue(PREFIX_TOTAL_STOCK).isPresent()) {
            editPrescriptionDescriptor.setTotalStock(ParserUtil.parseTotalStock(
                argMultimap.getValue(PREFIX_TOTAL_STOCK).get()));
        }
        if (argMultimap.getValue(PREFIX_NOTE).isPresent()) {
            editPrescriptionDescriptor.setNote(ParserUtil.parseNote(
                argMultimap.getValue(PREFIX_NOTE).get()));
        }
        // parseTagsForEdit(argMultimap.getAllValues(PREFIX_TAG)).ifPresent(editPersonDescriptor::setTags);

        if (!editPrescriptionDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }

        return new EditCommand(index, editPrescriptionDescriptor);
    }

    // /**
    //  * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
    //  * If {@code tags} contain only one element which is an empty string, it will be parsed into a
    //  * {@code Set<Tag>} containing zero tags.
    //  */
    // private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws ParseException {
    //     assert tags != null;

    //     if (tags.isEmpty()) {
    //         return Optional.empty();
    //     }
    //     Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
    //     return Optional.of(ParserUtil.parseTags(tagSet));
    // }

}
