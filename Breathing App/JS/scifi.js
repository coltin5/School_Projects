const circle = document.getElementById('circle');
const title = document.getElementById('title');


let inhale = parseInt(document.getElementById('inhale').value);
let hold1 = parseInt(document.getElementById('hold1').value);
let exhale = parseInt(document.getElementById('exhale').value);
let hold2 = parseInt(document.getElementById('hold2').value);
let totalTime = (inhale + exhale + hold1 + hold2) * 1000;
let exhaleTime = (exhale * 1000);
let hold1Time = (hold1 * 1000);
let inhaleTime = (inhale * 1000);
let hold2Time = (hold2 * 1000);





breathAnimation()

function breathAnimation() {

    title.innerHTML = 'Breathe In!';
    circle.className = 'circle inhale';

    setTimeout(() => {

        title.innerHTML = 'Hold';
        circle.className = 'circle hold1';
        setTimeout(() => {

            title.innerHTML = 'Breathe Out!';
            circle.className = 'circle exhale';
            setTimeout(() => {

                title.innerHTML = 'Hold!';
                circle.className = 'circle hold2';

            }, exhaleTime);
        }, hold1Time);
    }, inhaleTime);
}

setInterval(breathAnimation, totalTime);
