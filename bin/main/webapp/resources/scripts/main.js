'use strict';
 var $tags = $('#tag-list').select2({
   width: '100%',
   placeholder: 'Select tags'
 });
 $('#save-tag').on('click', function(e){
   e.preventDefault();
   $('.loading').removeClass('hidden');
   //make ajax request to save to db
   var existing = [];
   if($tags.val() != null)
      existing = $tags.val();
   var newtag = $('#tag-name').val();
   if(newtag !== '') {
       var tagDesc = $('#tag-desc').val();
   var $option = $('<option></option');
   $option.val(newtag);
   $option.text(newtag);
   $tags.append($option).trigger('change'); // add it to the list of selections
   //after adding the option let's make it one of the selected
   //check if there was no selected tags first
   existing.push(newtag);
   $tags.val(existing).trigger('change');
   }
    //close modal after saving
    //$('#addTag').modal('hide');
   //make ajax request to save to db
   $.ajax({
       url: "http://localhost:8080/SnippetHub/savetags",
       type: "POST",
        data: JSON.stringify({tagTitle: newtag, tagDescription:tagDesc}),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
       success: function() {
           //close modal after saving
           setTimeout(function(){
                $('#addTag').modal('hide');
                $('.loading').addClass('hidden');
           },3000);
       }
   });
   
   
   $('#tag-name').val('');
 });

var Search = {
    //wire up event listeners
    keystrokeTimeout: "",
    ajaxRequest: "",
    init: function() {
            var searchBox = $(".search-box");
            this.bindEvents(searchBox)
    },
    bindEvents: function(searchBox) {
        var that = this;
        var searchTerm = "XXX"; //I needed to do this because it was hitting getbytitle instead of search if it is empty
        searchBox.on('keyup', function(){
            if(searchBox.val() != "")
                searchTerm = searchBox.val();
            else
                searchTerm = "XXX";
            that.keyupHandler(searchTerm);
        });
    },
    keyupHandler: function(searchTerm) {
        var that = this;
        window.clearTimeout(this.keystrokeTimeout);
        //this.keystrokeTimeout = window.setTimeout(function(){
            that.search(searchTerm);
        //}, 350);
    },
    search: function(searchTerm) {
        var url = "http://localhost:8080/SnippetHub/snippets/search/" + searchTerm;
//        this.ajaxRequest = $.get(url).success(function(res) {
//            $(".snippets-row").html(res);
//        });
        $.ajax({
            url:url,
            success: function(res) {
                $(".snippets-row").html(res);
                Prism.highlightAll();
            }
        })
    }
};
(function(){
    Search.init();
})();