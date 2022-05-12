const source = document.getElementsByClassName("featuredpimgev"), sourcetext = document.getElementsByClassName("featuredpimgevt");
let target = document.getElementById("featuredpimg"), targetdate = document.getElementById("featureddate");
let index = 0;
let tp;
const maxindex = source.length - 1;

function decideImage()
{
    target.src = source[index].src;
    targetdate.innerHTML = sourcetext[index].getAttribute("value");
}

function nextImage()
{
    index == maxindex ? index = 0 : index++;
    decideImage();
}

function previousImage()
{
    index == 0 ? index = maxindex : index--;
    decideImage();
}

target.addEventListener("touchstart", function (e)
{
    tp = e.touches[0].clientX;
});

target.addEventListener("touchend", function (e)
{
    const ltp = e.changedTouches[0].clientX;
    if(tp > (ltp + 10))
        previousImage();
    else if(tp < (ltp - 10))
        nextImage();
});

document.addEventListener("DOMContentLoaded", function()
{
    decideImage();
});

document.getElementById("nextfeatured").addEventListener("click", function()
{
    nextImage();
});

document.getElementById("previousfeatured").addEventListener("click", function()
{
    previousImage();
});