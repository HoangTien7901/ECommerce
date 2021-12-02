function catalogDrillDownFormatter(data, type, row, meta) {
    if (row.id && data) {
        return '<a class="btn-detail-index" href="' +  path +'/home/profile/'+ row.id +'" data-id="' + row.id + '">' + data + '</a>';
    }
    else {
        return data;
    }
}

function statusFormatter(data, type, row, meta) {
    if (data) {
        return '<span class="badge badge-success">Use</span>';
    }
    else {
        return '<span class="badge badge-secondary">Not Use</span>';
    }
}

function dateFormatter(data, type, row, meta) {
    if (!data)
        return data;

    let dateFormat = ['YYYY-MM-DDThh:mm:ss', develoverSettings.formatDate];

    let date = moment(data, dateFormat);
    return date.isValid() ? date.year() === 1900 ? '' : date.format(develoverSettings.formatDate) : data;
}

function imageFormatter(value, row, index) {
    return '<img src="' + '/resources/stores/dist/img/' + value + '" width="100" />';
}