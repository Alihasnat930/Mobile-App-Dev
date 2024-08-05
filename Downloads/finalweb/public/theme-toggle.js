document.addEventListener('DOMContentLoaded', () => {
    const themeToggleButton = document.querySelector('#theme-toggle');
    const themeStylesheet = document.getElementById('theme-stylesheet');

    // Load the saved theme from localStorage or default to dark
    const savedTheme = localStorage.getItem('theme') || 'dark';
    themeStylesheet.href = savedTheme === 'light' ? 'style-light.css' : 'style-dark.css';
    updateIcon(savedTheme);

    // Toggle theme on button click
    themeToggleButton.addEventListener('click', () => {
        const currentTheme = themeStylesheet.href.includes('style-light.css') ? 'light' : 'dark';
        const newTheme = currentTheme === 'dark' ? 'light' : 'dark';
        themeStylesheet.href = newTheme === 'light' ? 'style-light.css' : 'style-dark.css';
        localStorage.setItem('theme', newTheme);
        updateIcon(newTheme);
    });

    function updateIcon(theme) {
        const icon = themeToggleButton.querySelector('i');
        icon.className = theme === 'light' ? 'fas fa-moon' : 'fas fa-sun';
    }
});

// Animation
document.addEventListener('DOMContentLoaded', () => {
    // Function to animate the progress bars
    function animateProgressBars(entries, observer) {
        entries.forEach(entry => {
            if (entry.isIntersecting && !entry.target.classList.contains('animated')) {
                const skillCircles = entry.target.querySelectorAll('.circle');
                skillCircles.forEach(circle => {
                    const percent = circle.getAttribute('data-percent');
                    const circleElement = circle.querySelector('circle:nth-child(2)');
                    const radius = circleElement.r.baseVal.value;
                    const circumference = 2 * Math.PI * radius;
                    const offset = circumference - (percent / 100) * circumference;
                    circleElement.style.strokeDasharray = circumference;
                    circleElement.style.strokeDashoffset = offset;
                });
                entry.target.classList.add('animated');
                observer.unobserve(entry.target); // Stop observing once animated
            }
        });
    }
  
    // Create an IntersectionObserver instance
    const observer = new IntersectionObserver(animateProgressBars, {
        root: null,
        rootMargin: '0px',
        threshold: 0.1 // Adjust this value as needed
    });
  
    // Target the "About" section for observation
    const aboutSection = document.getElementById('about');
    if (aboutSection) {
        observer.observe(aboutSection);
    }
  });

document.addEventListener('DOMContentLoaded', function () {
  // Initialize main Swiper
  const mainSwiper = new Swiper('.swiper-container', {
      direction: 'horizontal',
      loop: true,
      autoplay: {
          delay: 5000, // Change slide every 5 seconds
          disableOnInteraction: false,
      },
      pagination: {
          el: '.swiper-pagination',
          clickable: true,
      },
      navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
      },
  });

  // Initialize nested Swipers
  const nestedSwipers = document.querySelectorAll('.nested-swiper-container');
  nestedSwipers.forEach(container => {
      new Swiper(container, {
          direction: 'horizontal',
          loop: true,
          slidesPerView: 1,
          spaceBetween: 10,
          autoplay: {
              delay: 3000, // Change slide every 3 seconds
              disableOnInteraction: false,
          },
      });
  });
});