var graphic = {
    object : $('#highchart'),

    graphicCreate: function (categoriesData, seriesData, titles) {
        this.object.highcharts({
            chart: {
                zoomType: 'x',
                spacingRight: 20
            },
            title: {
                text: titles[0].title
            },
            subtitle: {},
            credits: {
                enabled: false
            },
            xAxis: {
                lineWidth: 0,
                minorGridLineWidth: 0,
                lineColor: 'transparent',
                minorTickLength: 0,
                tickInterval: 0,
                tickLength: 0,
                tickmarkPlacement: 'on',
                //Affichage des dates précédemment sélectionnées dans la requete sql
                categories: categoriesData,
                labels: {
                    enabled: false,
                    //Step 2 permet d'afficher qu'une date sur deux
                    step: 5,
                    //rotation 90 permet la rotation a 90° des dates
                    rotation: 1
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: titles[1].yAxis
                }
            },
            tooltip: {
                shared: true,
                //Ajout d'une unité de mesure lors du survole d'un point du graphique
                valueSuffix: ''
            },
            legend: {
                //Legend permet d'afficher la légende sous le graphique.
                //La légende affiche, le nom de la courbe, ainsi que sa couleur
                //Pas forcément utile lorsqu'il n'y a qu'une seule courbe
                //false pour désactiver et true pour activer
                enabled: false
            },
            plotOptions: {
                area: {
                    fillColor: {
                        fillcolor: 'red',
                        linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                        stops: [
                            [0, Highcharts.getOptions().colors[4]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[4]).setOpacity(0).get('rgba')]
                        ]
                    },
                    lineWidth: 1,
                    marker: {
                        enabled: false
                    },
                    shadow: true,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },
            series: [{
                type: 'area',
                name: titles[2].name,
                //Affichage des onlinemmations précédemment sélectionnées dans la requete sql
                data: seriesData
            }]
        });
    }
};


$(document).ready(function () {
    var titles = [{title: 'Mes visites depuis 15 jours'}, {yAxis: 'Nombre de visites'}, {name: 'URL visitée'}];
    console.log(titles);
    // graphic.graphicCreate(data['date'], data['specific'], titles);

});
