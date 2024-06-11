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

   // const formSelect2 = $("#main-modal").find('.select2');
   // // select2
   //  if (formSelect2.length){
   //      formSelect2.wrap('<div class="position-relative"></div>');
   //      formSelect2
   //          .select2({
   //              placeholder: 'Pilih Group',
   //              dropdownParent : formSelect2.parent()
   //          });
   //  }


   // datab-table-declaration
    var dt_kelompok_table = $("#table-kelompok"),
        statusObj = {
                0:{title : "Non Aktif"},
                1:{title : "Aktif"},
        },
        riwayatObj = {
                0: {title : "Non Aktif"},
                1: {title : "Aktif"},
        };

       var ajaxUrl = $('#kelompok-title').attr('href');
       var dt_kelompok = dt_kelompok_table.DataTable({
           ajax: ajaxUrl,
           columns: [
               { data: 'idLembaga'},
               { data: 'idLembaga'},
               { data: 'kode' },
               { data: 'nama' },
               { data: 'status' },
               { data: '' }
           ],
           columnDefs: [
               {
                   classname: 'control',
                   searchable: false,
                   orderable: false,
                   responsivePriority: 2,
                   targets: 0
                   /*
                   render: function (data, type, full, meta) {
                       var $item = full['id'];
                       return '<span>'+ $item + '</span>';
                   }
                    */
               },
               {
                   targets: 1,
                   searchable: true,
                   orderable: true,
                   render: (data, type, full) => {
                       var $item = full['idLembaga'];
                       return '<span>' + $item + '</span>';
                   }
               },
               {
                   targets: 2,
                   searchable: true,
                   orderable: true,
                   render: (data, type, full, meta)=> {
                       var $item = full['kode'];
                       return '<span>' + $item + '</span>';
                   }
               },
               {
                   targets: 3,
                   searchable: true,
                   orderable: true,
                   render: (data, type, full, meta)=> {
                       var $item = full['nama'];
                       return '<span>' + $item + '</span>';
                   }
               },
               {
                   targets: 4,
                   searchable: true,
                   orderable: true,
                   render: (data, type, full, meta) => {
                       var $item = full['status'];
                       return '<span>' + $item + '</span>';
                   }
               },
               {
                   targets: -1,
                   title : 'Actions',
                   searchable: false,
                   orderable: false,
                   render: function (data, type, full, meta) {
                       var id = full['idLembaga'];
                       var kode = full['kode'];
                       var editUrl = ajaxUrl.replace('data', 'edit') + '/' + id + '/' + kode;
                       var deleteUrl = ajaxUrl.replace('data', 'delete') + '/' + id + '/' + kode;
                       return (
                           '<div class="d-inline-block text-nowrap">' +
                           '<button class="btn btn-xs btn-primary btn-edit" href="'+ editUrl + '"><i class="ti ti-edit"></i>Edit</button> &nbsp;' +
                           '<button class="btn btn-xs btn-danger btn-delete" href="' + deleteUrl + '"><i class="ti ti-trash"></i></button>' +
                           '</div>'
                       );
                   }
               }
           ],
           lengthMenu : [5, 10, 20 , 30, 50, 100]
       });

       dt_kelompok.on('order.dt search.dt', function(){
           let i = 1;

           dt_kelompok.cells(null, 0, { search: 'applied', order: 'applied'})
               .every(function (cell){
                   this.data(i++);
               });
       }).draw();

    $('.dataTable_length').addClass('mt-2 mt-sm-0 mt-md-3 me-2');
    $('.dt-buttons').addClass('d-flex flex-nowrap');

    // btn add click
    $('#btn-add').click(function () {
        var url = $(this).attr('href');
        showModal(url, '');
    });

    // from submit
    $('#main-modal').on('submit', '#form-kelompok', function (e){
        e.preventDefault();
        var ajaxUrl = $(this).attr('action');
        const data = convertFormToJSON($(this));
        ajaxSubmit(ajaxUrl, data, dt_kelompok);
    });

    // edit data
    $("#table-kelompok").on('click', '.btn-edit', function (){
        var url = $(this).attr('href');
        showModal(url, '');
    });

    // delete data
    $("#table-kelompok").on('click', '.btn-delete', function (){
       var url = $(this).attr('href');
       showModal(url, '');
    });
});