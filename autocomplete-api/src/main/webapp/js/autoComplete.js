function autoComplete1(link,callback) {
   

        $.ajax({
        type: 'GET',
        url: link ,
        success: callback
    });
}