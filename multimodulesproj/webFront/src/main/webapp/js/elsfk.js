/**
 * Created by 15482 on 2017/7/24.
 */

var divLength = 20;
var divHeight = 80;
var divWidth = 40;
var elsfkCounts = 4;
var elsfkHeight = 25;
var elsfkWidth = 16;
var rotatePoint = [2,2];

var shapes = [
    [0,0, 1,0, 2,0, 2,1],
    [0,1, 1,1, 2,1, 2,0],

    [0,0, 1,0, 2,0, 3,0],
    [0,0, 1,0, 2,0, 3,0],

    [0,0, 0,1, 1,0, 1,1],
    [0,0, 0,1, 1,0, 1,1],

    [0,0, 1,0, 2,0, 1,1],
    [0,1, 1,1, 2,1, 1,0],

    [0,0, 1,0, 1,1, 2,1],
    [0,1, 1,0, 1,1, 2,0]

];

var getRandomShape = function () {
    var r = Math.floor(Math.random()*shapes.length);
    return shapes[r];
}

// var move_right = function (v) {
//     for(var i=0; i<v.length; i++){
//         v[i].style.left = (parseInt(v[i].style.left) + 20) + 'px';
//     }
// };
// var move_left = function (v) {
//     for(var i=0; i<v.length; i++){
//         v[i].style.left = (parseInt(v[i].style.left) - 20) + 'px';
//     }
// };
// var move_down = function (v){
//     for(var i=0; i<v.length; i++){
//         v[i].style.top = (parseInt(v[i].style.top) + 20) + 'px';
//     }
// };
var rotate = function (v){

};
