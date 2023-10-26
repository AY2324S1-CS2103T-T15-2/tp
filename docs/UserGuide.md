---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# BayMeds v.2103 User Guide

BayMeds v.2103, (a.k.a BayMeds), is a **desktop application for managing your prescriptions**. While it has a GUI (Graphical User Interface), most of the user interactions happen using a CLI (Command Line Interface). If you like to type fast, BayMeds can get your prescription management tasks done faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `BayMeds.jar` from [here](https://github.com/AY2324S1-CS2103T-T15-2/tp/releases/tag/v1.3.trial).

1. Copy the file to the folder you want to use as the _home folder_ for BayMeds.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar BayMeds.jar` command to run the application.<br>
   A GUI similar to the one below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type commands in the command box and press Enter to execute it. <br> e.g. typing the command **`help`** and pressing Enter will open the help window.<br>

   Some example commands you can try:

   * `list` : Lists all prescriptions.

   * `add mn/Doxazosin f/Daily` : Adds a prescription `Doxazosin` to the list of prescriptions.

   * `delete 2` : Deletes the second prescription from the current list of prescriptions.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `<>` are the parameters to be supplied by the user.<br>
  e.g. in `add mn/<medication_name>`, `<medication_name>` is a parameter which can be used as `add mn/Aspirin`.

* Items in square brackets are optional.<br>
  e.g. `mn/<medication_name> [sd/<start_date>]` can be used as `mn/Aspirin sd/25/10/2023` or as `mn/Aspirin`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `mn/<medication_name> f/<frequency>`, `f/<frequency> mn/<medication_name>` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`) is not allowed.<br>

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help : `help`

Opens a help window. Embedded in the help window is a link to the official BayMeds user guide.

Format:
```
help
```


### Adding a prescription : `add`

Adds a prescription to the list of prescriptions.

Format:
```
add
  mn/<medication_name>
  [d/<dosage>]
  [f/<frequency>]
  [sd/<start_date>]
  [ed/<end_date>]
  [exp/<expiry_date>]
  [ts/<total_stock>]
  [n/<note>]
```

* If your prescriptions are to be taken on uneven intervals, or falls outside of the Daily/Weekly/Monthly categories, add 2 separate entries into the list of prescriptions.
<br> For instance, if your prescriptions are to be taken every Wednesdays and Sundays, add a weekly entry for Wednesdays and another weekly entry for Sundays. BayMeds will track both entries separately and remind you both on Wednesdays and Sundays to consume your prescriptions.
  * `add mn/Accutane sd/27/09/2023 f/Weekly`.
  * `add mn/Accutane sd/01/10/2023 f/Weekly`.

* `<start_date>` and `<end_date>` should be in dd/mm/yyyy format.
  * e.g. "20/09/2023".
* Since `--start <start_date>` is an optional input, if there is none given, the input date of the entry will be used as the default start date.
* Note can consist of any text.
  * e.g. "To be taken after meals".
  * e.g. "Take after food".

Examples:
* `add mn/Aspirin d/1 f/Daily sd/20/09/2023 ed/03/10/2024 exd/04/10/2024 ts/100 n/Take during meals`.
* `add mn/Amoxicillin f/Weekly sd/20/09/2023 ed/03/10/2024`.
* `add mn/Doxazosin`.

Example output of add command in BayMeds:

<img src="images/ui/Ui-add.png" alt="Example output of add command" width="460" height="330">

### Listing all prescriptions : `list`

Shows a list of all prescriptions.

Format:
```
list
```

Example usage of list command in BayMeds:

<img src="images/ui/Ui-list.png" alt="Example of list command" width="460" height="330">

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating persons by name : `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a prescription : `delete`

Deletes the specified prescription from the list of prescriptions.

Format:
```
delete
  --medication <medication_name>
```

* `<medication_name>` should not be empty.

Examples:
* `delete --medication "Aspirin"`.
* `delete --medication "Amoxicillin"`.
* `delete --medication "Doxazosin"`.

Example usage of delete command in BayMeds:

<img src="images/ui/Ui-delete.png" alt="Example of delete command" width="460" height="330">

### Listing untaken medication : `list today`

Lists all remaining medications to be taken for the day.

Format:
```
list today
```

Examples:
* `list today`.

Example usage of list today command in BayMeds:

<img src="images/ui/Ui-list_today.png" alt="Example of list today command" width="460" height="330">

### Marking a medication as taken : `take`

Takes a specified dose from a prescription in the list of prescriptions.

Format:
```
take
  INDEX
  [d/<dosage>]
```

* Takes a dose from the prescription at the specified `INDEX`. The index refers to the index number shown in the displayed prescription list. The index **must be a positive integer** 1, 2, 3, …​
* Existing consumption count will be increased by the input value.
* Existing stock will be decreased by the input value.
* Since `d/<dosage>` is an optional input, if there is none given, the default dosage to take will be set as 1.

Examples:
* `take 1 d/2`
* `take 2`

Example output of take command in BayMeds:

<img src="images/ui/Ui-take.png" alt="Example output of take command" width="460" height="330">

### Saving the data

BayMeds data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

BayMeds data are saved automatically as a JSON file `[JAR file location]/data/prescriptionList.json and completedPrescriptionList.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, BayMeds will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous BayMeds home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action          | Format, Example                                                                                                                                                                                                                                                 |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Help**        | `help`                                                                                                                                                                                                                                                          |
| **Add**         | `add mn/<medication_name> [d/<dosage>] [f/<frequency>]  [sd/<start_date>] [ed/<end_date>] [exd/<expiry_date>] [ts/<total_stock>] [n/<note>]`, <br> e.g. `add mn/Aspirin d/1 f/Daily sd/20/09/2023 ed/03/10/2024 exp/04/10/2024 ts/100 n/Take during meals` |
| **Delete**      | `delete <index>`, <br> e.g. `delete 2`                                                                                                                                                                              |
| **Mark**        | `take <index> [d/<dosage_taken>]`, <br> e.g. `take 1 d/1`                                                                                                       |
| **List**        | `list`                                                                                                                                                                                                                                                          |
|  **List today** | `list today`                                                                                                                                                                                                                                                    |
