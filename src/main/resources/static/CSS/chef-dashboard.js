<script>
        const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        
        const today = new Date();
        const dayName = days[today.getDay()];
        const monthName = months[today.getMonth()];
        const dateString = `${dayName} ${today.getDate()} ${monthName}, ${today.getFullYear()}`;
        
        document.querySelector('.header-date').textContent = dateString;
    </script>