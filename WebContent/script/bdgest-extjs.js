var buttonsList = new Array('0','A','B',"C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"," ");

Ext.onReady(function(){
    var lb = Ext.get('lib-bar');
    if(lb){
        lb.show();
    }

	displayItem();
});


function displayItem() {
	
	var buttonsBarObj1 = new Ext.Toolbar("{id:'menu1', xtype: 'buttongroup', columns: "+buttonsList.length/2+"}");
	var buttonsBarObj2 = new Ext.Toolbar("{id:'menu2', xtype: 'buttongroup', columns: "+buttonsList.length/2+"}");
	
	var storeTemp = new Ext.data.JsonStore({
        url: 'Proxy?action=series&lettre='+"A".charCodeAt(0),
        root: 'listeObject',
        remoteSort:true,
        fields: ['idBel', 'nom', 'nbAlbum', 'langue']
    });
	storeTemp.load();
	
    var listView= new Ext.list.ListView({
    	store: storeTemp,
        multiSelect: false,
        emptyText: '',
        autoScroll: true,
        columnSort:false,
        columnResize:false,
        deferHeight:true,
        id:'listView',
        width: 395,
        height: 420,
        /*reserveScrollOffset: true,*/

        columns: [{
            header: 'idBel',
            width: .1,
            dataIndex: 'idBel'
        },{
            header: 'Nom',
            width: .6, 
            dataIndex: 'nom'
        },{
            header: 'nbAlbum',
            dataIndex: 'nbAlbum',
            width: .1
        },{
            header: 'langue',
            dataIndex: 'langue',
            width: .2
        }]
        
    });

	
	
	for (i = 0; i< buttonsList.length; i++) {
	
		lettre = buttonsList[i];
		if (lettre == " ") {
			lettre = "_";
		}
	
		var action = new Ext.Action({
	        text: lettre,
	        handler: function(){
	    		// TODO : add call JSon data store
	            alert("Coucou : "+this.text);
	            var store = new Ext.data.JsonStore({
	                url: 'Proxy?action=series&lettre='+this.text.charCodeAt(0),
	                root: 'listeObject',
	                fields: ['idBel', 'nom', 'nbAlbum', 'langue']
	            });
	            store.load();
	            listView.bindStore(store);
	        }/*,
	        iconCls: 'blist'*/
	    });
		if (i%2 != 0) {
			buttonsBarObj1.add(action);
		} else {
			buttonsBarObj2.add(action);
		}
	}
	

    var span = new Ext.Panel({
	    width: 400,
	    height: 500,
	    style: 'margin-top:15px',
	    /*bodyStyle: 'padding:1px',*/
        title: 'Liste des objets',
        layout: 'table',
        /*collapsible:true,*/
        autoScroll: false,
        layoutConfig: {
            // The total column count must be specified here
            columns: 1
        }
    });
    var spanButton = new Ext.Panel({
	    width: 400,
	    height: 420,
	    layout:'table',
	    autoScroll: false,
        layoutConfig: {
            // The total column count must be specified here
            columns: 1
        }
    });
    span.add(buttonsBarObj1);
    span.add(buttonsBarObj2);
    spanButton.add(listView);
    span.add(spanButton);
    span.render('listeBoutons');
    
}
