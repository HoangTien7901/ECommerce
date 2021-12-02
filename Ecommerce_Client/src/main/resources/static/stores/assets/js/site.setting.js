let decimalSymbol = ".";
let decimalCharacterAlternative = ".";
let thousandsSymbol = ",";
let roundPacking = 0;
let roundQuantity = 2;
let roundPercent = 2;
let roundAmount = 2;
let roundAmountVND = 0;
let formatDate = "DD/MM/YYYY";
let formatDateDatepicker = "dd/mm/yyyy";
let swalOptions = {
    timer: 1000,
    closeOnClickOutside: true,
    closeOnEsc: true
};
const develoverSettings = {
    decimalSymbol: decimalSymbol,
    thousandsSymbol: thousandsSymbol,
    roundPacking: roundPacking,
    roundQuantity: roundQuantity,
    roundAmount: roundAmount,
    roundAmountVND: roundAmountVND,
    formatDate: formatDate,
    formatDateDatepicker: formatDateDatepicker,
    OptionAutoNumericPacking: {
        decimalCharacter: decimalSymbol,
        decimalCharacterAlternative: decimalCharacterAlternative,
        digitGroupSeparator: thousandsSymbol,
        decimalPlaces: roundPacking,
        decimalPlacesRawValue: roundPacking,
        decimalPlacesShownOnBlur: roundPacking,
        decimalPlacesShownOnFocus: roundPacking,
        emptyInputBehavior: "zero"
    },
    OptionAutoNumericQuantity: {
        decimalCharacter: decimalSymbol,
        decimalCharacterAlternative: decimalCharacterAlternative,
        digitGroupSeparator: thousandsSymbol,
        decimalPlaces: roundQuantity,
        decimalPlacesRawValue: roundQuantity,
        decimalPlacesShownOnBlur: roundQuantity,
        decimalPlacesShownOnFocus: roundQuantity,
        emptyInputBehavior: "zero"
    },
    OptionAutoNumericPercent: {
        decimalCharacter: decimalSymbol,
        decimalCharacterAlternative: decimalCharacterAlternative,
        digitGroupSeparator: thousandsSymbol,
        decimalPlaces: roundQuantity,
        decimalPlacesRawValue: roundPercent,
        decimalPlacesShownOnBlur: roundPercent,
        decimalPlacesShownOnFocus: roundPercent,
        emptyInputBehavior: "zero"
    },
    OptionAutoNumericAmount: {
        decimalCharacter: decimalSymbol,
        decimalCharacterAlternative: decimalCharacterAlternative,
        digitGroupSeparator: thousandsSymbol,
        decimalPlaces: roundAmount,
        decimalPlacesRawValue: roundAmount,
        decimalPlacesShownOnBlur: roundAmount,
        decimalPlacesShownOnFocus: roundAmount,
        emptyInputBehavior: "zero"
    },
    OptionAutoNumericAmountVND: {
        decimalCharacter: decimalSymbol,
        decimalCharacterAlternative: decimalCharacterAlternative,
        digitGroupSeparator: thousandsSymbol,
        decimalPlaces: roundAmountVND,
        decimalPlacesRawValue: roundAmountVND,
        decimalPlacesShownOnBlur: roundAmountVND,
        decimalPlacesShownOnFocus: roundAmountVND,
        emptyInputBehavior: "zero"
    },
    swal: {
        timer: swalOptions.timer,
        closeOnClickOutside: swalOptions.closeOnClickOutside,
        closeOnEsc: swalOptions.closeOnEsc
    }

}