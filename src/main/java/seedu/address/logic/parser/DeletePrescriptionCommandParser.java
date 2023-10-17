package seedu.address.logic.parser;

import static seedu.address.logic.MessagesPrescription.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntaxPrescription.PREFIX_INDEX;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeletePrescriptionCommand;
import seedu.address.logic.parser.exceptions.ParseException;



/**
 * Parses input arguments and creates a new DeletePrescriptionCommand object
 */
public class DeletePrescriptionCommandParser implements ParserPrescription<DeletePrescriptionCommand> {
    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return java.util.stream.Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Parses the given {@code String} of arguments in the context of the DeletePrescriptionCommand
     * and returns an DeletePrescriptionCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeletePrescriptionCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_INDEX);

        if (!arePrefixesPresent(argMultimap, PREFIX_INDEX)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeletePrescriptionCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_INDEX);

        try {
            Index index = ParserUtilPrescription.parseIndex(argMultimap.getValue(PREFIX_INDEX).get());
            return new DeletePrescriptionCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeletePrescriptionCommand.MESSAGE_USAGE), pe);
        }
    }
}
