function loadImages() {

	$.ajax({
		type: 'GET',
		url: "/listShoes",
		success: function(data) {
			$("#listShoes").html("");
			for (var i = 0; i < data.length; i++) {

				var shoes = data[i];
				console.log(shoes.shoesPrice);
				
				/*var imageTag = '<img src="data:image/png;charset=utf-8;base64,'+shoes.shoesImg+' alt="noImage" width="300" height="300">';
				
				var shoesCategory = shoes.shoesCategory;
				var shoesName = shoes.shoesName;
				var shoesPrice = shoes.shoesPrice;
				var shoesId = shoes.id;
				
				var contents = shoesCategory + ' ' + shoesName + ' ' + shoesPrice ;
				
				var addToCartBtn = '<input id="addToCart" type="submit" value="Add to Cart"/>';
				
				imageTag +=addToCartBtn;
				
				
				$("#listShoes").append(imageTag);
				*/
				
				
				var recIndex = "record" +i;
				console.log("recIndex:"+recIndex);
				
				var shoes = data[i];
				var image = new Image(415,225);
				image.src = 'data:image/jpg;base64,' + shoes.shoesImg;
				
				var shoesPrice = shoes.shoesPrice;
				
				var shoesCategory = shoes.shoesCategory;
				var shoesName = shoes.shoesName;
				var shoesId = shoes.id;
				
				var contents = shoesCategory + ' ' + shoesName;
				
				var htmlImageBlock='<div class="col"><div class="card shadow-sm"><div id="pp'+recIndex+'"></div><div class="card-body"><p class="card-text">'+contents+'</p><div class="d-flex justify-content-between align-items-center"> <div class="btn-group"> <form action="./addToCart" method="POST"><input type="hidden" name="shoesId" value="'+shoesId+'"/><button type="submit" class="btn btn-sm btn-outline-primary">Add to cart</button> </form> </div><small class="text-muted">price: '+shoesPrice+'</small></div></div></div></div>';
				$("#listShoes").append(htmlImageBlock);
				
				$("#pp"+recIndex).append(image);
				


		
        
        

			}
		}
	});

}