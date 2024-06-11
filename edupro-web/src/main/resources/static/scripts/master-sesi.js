$(function (){
    if (isDarkStyle) {
        borderColor = config.colors_dark.borderColor;
        bodyBg = config.colors_dark.bodyBg;
        headingColor = config.colors_dark.headingColor;
    } else {
        borderColor = config.colors.borderColor;
        bodyBg = config.colors.bodyBg;
        headingColor = config.colors.headingColor;
    }

    // datatable declaration
    var dt_sesi_table = $("#table-sesi"),
        statusObj = {
            0: {title: "Non Aktif"},
            1: {title: "Aktif"},
        },
        riwayatObj = {
            0: {title: "Non Aktif"},
            1: {title: "Aktif"},
        };

    if(dt_sesi_table.length > 0) {
        // datatable declaration

        var ajaxUrl = $('#sesi-title').attr('href');
        var dt_table = dt_sesi_table.DataTable({
            ajax: ajaxUrl,
            columns: [
                { data: 'tahunPelajaran' },
                { data: 'tahunPelajaran' },
                { data: 'urut' },
                { data: 'kodeKurikulum' },
                { data: 'status' },
                { data: '' }
            ],
            columnDefs: [
                {
                    className: 'control',
                    searchable: false,
                    orderable: false,
                    responsivePriority: 2,
                    targets: 0
                },
                {
                    targets: 1,
                    searchable: true,
                    orderable: true,
                    render: (data, type, full, meta) => {
                        var $item = full['tahunPelajaran'];
                        return '<span>'+$item +'</span>';
                    }
                },
                {
                    targets: 2,
                    searchable: true,
                    orderable: true,
                    render: (data, type, full, meta) => {
                        var $item = full['urut'];
                        return '<span>'+$item +'</span>';
                    }
                },
                {
                    targets: 3,
                    searchable: true,
                    orderable: true,
                    render: (data, type, full, meta) => {
                        var $item = full['kodeKurikulum'];
                        return '<span>'+$item +'</span>';
                    }
                },
                {
                    targets: 4,
                    searchable: true,
                    orderable: true,
                    render: (data, type, full, meta) => {
                        var $item = full['status'];
                        return '<span>'+$item +'</span>';
                    }
                },
                {
                    targets: -1,
                    title: 'Actions',
                    searchable: false,
                    orderable: false,
                    render: function (data, type, full, meta) {
                        var tahun = full['tahunPelajaran'];
                        var urut = full['urut'];
                        var editUrl = ajaxUrl.replace('data','edit') +'/'+ tahun +'/'+ urut;
                        var deleteUrl = ajaxUrl.replace('data','delete')+'/'+ tahun +'/'+ urut;
                        return (
                            '<div class="d-inline-block text-nowrap">' +
                            '<button class="btn btn-xs btn-primary btn-edit" href="'+ editUrl +'"><i class="ti ti-edit"></i> Edit</button> &nbsp;' +
                            '<button class="btn btn-xs btn-danger btn-delete" href="'+ deleteUrl +'"><i class="ti ti-trash"></i></button>' +
                            '</div>'
                        );
                    }
                }
            ],
            lengthMenu: [5, 10, 20, 50, 70, 100]
        });

        dt_table.on('order.dt search.dt', function () {
            let i = 1;

            dt_table.cells(null, 0, { search: 'applied', order: 'applied' })
                .every(function (cell) {
                    this.data(i++);
                });
        }).draw();
    }

    $('.dataTables_length').addClass('mt-2 mt-sm-0 mt-md-3 me-2');
    $('.dt-buttons').addClass('d-flex flex-wrap');

    // btn add click
    $("#btn-add").click(function (){
        var url = $(this).attr('href');
        showModal(url,'');
    });

    // from submit
    $('#main-modal').on('submit','#form-sesi', function (e){
        e.preventDefault();
        var ajaxUrl = $(this).attr('action');
        const data = convertFormToJSON($(this));
        ajaxSubmit(ajaxUrl, data, dt_sesi);
    });

    // edit data
    $("#table-sesi").on('click','.btn-edit', function (){
        var url = $(this).attr('href');
        showModal(url,' ');
    });

    // delete data
    $("#table-sesi").on('click','.btn-delete', function (){
        var url = $(this).attr('href');
        showModal(url,' ');
    });
});
