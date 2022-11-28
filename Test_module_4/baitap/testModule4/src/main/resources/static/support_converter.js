function converterDayCorrect(date) {
    const [year, month, day] = date.split('-');
    return [month, day, year].join('/');
}


function showInfoDelete(id) {
    document.getElementById("deleteId").value = id;
}
