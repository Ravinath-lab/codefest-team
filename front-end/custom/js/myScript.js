$(document).ready(function(){
    readCategory();
    readUsers();
    readProducts();
    
    ///===user=======================
    $("#saveUser").click(function(){
        var name = $("#username");
        var mobile = $("#mobile");
        var email = $("#email");
        var password = $("#pwd");
        var age = $("#age");
        var user = {
            "name":name.val(),
            "password":password.val(),
            "email":email.val(),
            "mobile":mobile.val(),
            "age":age.val()
        };
        var settings = {
            "url": "http://localhost:8080/user/save",
            "method": "POST",
            "timeout": 0,
            "headers": {
              "Content-Type": "application/json"
            },
            "data": JSON.stringify(user),
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            name.val("");
            email.val("");
            mobile.val("");
            age.val("");
            password.val("");
            alert("Success");
            readUsers();
          });
    });
    
    $("#updateUser").click(function(){
        var name = $("#updateUsername");
        var mobile = $("#updateMobile");
        var email = $("#updateEmail");
        var password = $("#updatePwd");
        var age = $("#updateAge");
        var id = $("#uid");
        var user = {
            "userId":id.val(),
            "name":name.val(),
            "password":password.val(),
            "email":email.val(),
            "mobile":mobile.val(),
            "age":age.val()
        };
        var settings = {
            "url": "http://localhost:8080/user/update",
            "method": "PUT",
            "timeout": 0,
            "headers": {
              "Content-Type": "application/json"
            },
            "data": JSON.stringify(user)
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            name.val("");
            email.val("");
            mobile.val("");
            age.val("");
            password.val("");
            alert("Success");
            readUsers();
          });
    });
  
  
    ///===product=======================
    $("#savePro").click(function(){
        var name = $("#pName");
        var buy = $("#buy");
        var sell = $("#sell");
        var qty = $("#qty");
        var cat = $("#catSelect");
        var pro = {
            "buyingPrice":buy.val(),
            "sellingPrice":sell.val(),
            "qty":qty.val(),
            "name":name.val(),
            "categoryId":cat.val()
        };
        var settings = {
            "url": "http://localhost:8080/product/save",
            "method": "POST",
            "timeout": 0,
            "headers": {
              "Content-Type": "application/json"
            },
            "data": JSON.stringify(pro),
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            name.val("");
            qty.val("");
            sell.val("");
            buy.val("");
            cat.val("");
            alert("Success");
            readProducts();
          });
    });
    
    $("#updatePro").click(function(){
        var name = $("#pUpdateName");
        var buy = $("#updateBuy");
        var sell = $("#updateSell");
        var qty = $("#updateQty");
        var cat = $("#updateCatSelect");
        var id = $("#proid");
        var pro = {
            "productId":id.val(),
            "buyingPrice":buy.val(),
            "sellingPrice":sell.val(),
            "qty":qty.val(),
            "name":name.val(),
            "categoryId":cat.val()
        };
        var settings = {
            "url": "http://localhost:8080/product/update",
            "method": "PUT",
            "timeout": 0,
            "headers": {
              "Content-Type": "application/json"
            },
            "data": JSON.stringify(pro),
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            name.val("");
            qty.val("");
            sell.val("");
            buy.val("");
            cat.val("");
            alert("Success");
            readProducts();
          });
    });

    ///===productCategory=======================
    $("#cSave").click(function(){
        var name = $("#cName");
        var des = $("#cDescription");
        var cat = {
            "name":name.val(),
            "description":des.val()
        };
        var settings = {
            "url": "http://localhost:8080/productCategory/save",
            "method": "POST",
            "timeout": 0,
            "headers": {
              "Content-Type": "application/json"
            },
            "data": JSON.stringify(cat),
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            name.val("");
            des.val("");
            alert("Success");
            readCategory();
          });
    });
    
    $("#cUpdate").click(function(){
        var name = $("#cUpdateName");
        var des = $("#UpdateDescription");
        var id = $("#catid");
        var cat = {
            "productCategoryId":id.val(),
            "name":name.val(),
            "description":des.val()
        };
        var settings = {
            "url": "http://localhost:8080/productCategory/update",
            "method": "PUT",
            "timeout": 0,
            "headers": {
              "Content-Type": "application/json"
            },
            "data": JSON.stringify(cat),
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            name.val("");
            des.val("");
            id.val("");
            alert("Success");
            readCategory();
          });
    });
    
});

//User Script area=======================================================================
function readUsers(){
    var settings = {
        "url": "http://localhost:8080/user/getAll",
        "method": "GET",
        "timeout": 0
      };

    $.ajax(settings).done(function (response) {
       loadUsers(response);
    });
}

function loadUsers(data){
    console.log(data);
    var tbody = $("#userTbody");
    var line = "";
    data.forEach(user =>{
        var row = "<tr><td>";
        row += user.id+"</td>";
        row += "<td>"+ user.name+"</td>";
        row += "<td>"+ user.email+"</td>";
        row += "<td>"+ user.mobile+"</td>";
        row += "<td>"+ user.age+"</td>";
        row += "<td>";
        row += "<button  type=\"button\" class=\"btn btn-warning btn-sm m-1 user-u\"  data-id=\""+user.id+"\">Update</button>";
        row += "<button  type=\"button\" class=\"btn btn-danger btn-sm m-1 user-d\"  data-id=\""+user.id+"\">Delete</button>";
        row += "</td></tr>";
        line += row;
    });
    tbody.html(line);
    $(".user-u").click(function(){
        var id = $(this).data("id");
        var settings = {
            "url": "http://localhost:8080/user/get/"+id,
            "method": "GET",
            "timeout": 0
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            $("#uid").val(id);
            $("#updateEmail").val(response.email);
            $("#updateUsername").val(response.name);
            $("#updateMobile").val(response.mobile);
            $("#updateAge").val(response.age);
          });
    });
    $(".user-d").click(function(){
        var id = $(this).data("id");
        if(confirm("Do you really want to delete this")){
            var settings = {
                "url": "http://localhost:8080/user/delete/"+id,
                "method": "DELETE",
                "timeout": 0
              };

              $.ajax(settings).done(function (response) {
                console.log(response);
                readUsers();
              });
        }
    });
}






//product script area=====================================================================
function readProducts(){
    var settings = {
        "url": "http://localhost:8080/product/getAll",
        "method": "GET",
        "timeout": 0
      };

    $.ajax(settings).done(function (response) {
       loadPros(response);
    });
}

function loadPros(data){
    console.log(data);
    var tbody = $("#proTbody");
    var line = "";
    data.forEach(pro =>{
        var row = "<tr>";
        row += "<td>"+pro.productId+"</td>";
        row += "<td>"+pro.name+"</td>";
        row += "<td>"+pro.buyingPrice+"</td>";
        row += "<td>"+pro.sellingPrice+"</td>";
        row += "<td>"+pro.qty+"</td>";
        row += "<td>"+pro.productCategory.name+"</td><td>";
        row += "<button type=\"button\" class=\"btn btn-warning btn-sm m-1 pro-u\"  data-id=\""+pro.productId+"\">Update</button>";
        row += "<button type=\"button\" class=\"btn btn-danger btn-sm m-1 pro-d\"  data-id=\""+pro.productId+"\">Delete</button>";
        row += "</td></tr>";
        line += row;
    });
    tbody.html(line);
    $(".pro-u").click(function(){
        var id = $(this).data("id");
        var settings = {
            "url": "http://localhost:8080/product/get/"+id,
            "method": "GET",
            "timeout": 0
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            $("#proid").val(id);
            $("#updateBuy").val(response.buyingPrice);
            $("#pUpdateName").val(response.name);
            $("#updateSell").val(response.sellingPrice);
            $("#updateQty").val(response.qty);
            $("#updateCatSelect").val(response.productCategory.productCategoryId);
          });
    });
    $(".pro-d").click(function(){
        var id = $(this).data("id");
        if(confirm("Do you really want to delete this")){
            var settings = {
                "url": "http://localhost:8080/product/delete/"+id,
                "method": "DELETE",
                "timeout": 0
              };

              $.ajax(settings).done(function (response) {
                console.log(response);
                readProducts();
              });
        }
    });
}





//category script area=====================================================================
function readCategory(){
    var settings = {
        "url": "http://localhost:8080/productCategory/getAll",
        "method": "GET",
        "timeout": 0
      };

    $.ajax(settings).done(function (response) {
       loadCategories(response);
    });
}
function loadCategories(data){
    console.log(data);
    var tr = $("#catTbody");
    var updateCatSelect = $("#updateCatSelect");
    var catSelect = $("#catSelect");
    
    var line = "";
    var options = "";
    data.forEach(category =>{
        var row = "<tr><td>";
        row += category.productCategoryId;
        row += "</td>";
        row += "<td>"+category.name+"</td>";
        row += "<td>"+category.description+"</td>";
        row += "<td>";
        row += "<button  type=\"button\" class=\"btn btn-warning btn-sm m-1 cat-u\" data-name=\"catUpdate\" data-id=\""+category.productCategoryId+"\">Update</button>";
        row += "<button  type=\"button\" class=\"btn btn-danger btn-sm m-1 cat-d\" data-name=\"catDelete\" data-id=\""+category.productCategoryId+"\">Delete</button>";
        row += "</td></tr>";
        line += row;
        
        var option = "<option value=\""+category.productCategoryId+"\">"+category.name+"</option>";
        options += option;
    });
    tr.html(line);
    updateCatSelect.html(options);
    catSelect.html(options);
    $(".cat-u").click(function(){
        var id = $(this).data("id");
        var settings = {
            "url": "http://localhost:8080/productCategory/get/"+id,
            "method": "GET",
            "timeout": 0
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
            $("#catid").val(id);
            $("#cUpdateName").val(response.name);
            $("#UpdateDescription").val(response.description);
          });
    });
    $(".cat-d").click(function(){
        var id = $(this).data("id");
        if(confirm("Do you really want to delete this")){
            var settings = {
                "url": "http://localhost:8080/productCategory/deactivate/"+id,
                "method": "PUT",
                "timeout": 0
              };

              $.ajax(settings).done(function (response) {
                console.log(response);
                readCategory();
              });
        }
    });
}


