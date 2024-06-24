document.addEventListener('DOMContentLoaded', function () {
    // Fetch data from PHP script
    const fetchDataUrl = 'fetch_data.php';
    fetch(fetchDataUrl)
        .then(response => response.json())
        .then(data => {
            console.log(data); // Log fetched data
            // Update room booked counts in HTML
            document.getElementById('deluxe-booked').textContent = data.deluxe;
            document.getElementById('family-booked').textContent = data.family;
            document.getElementById('penthouse-booked').textContent = data.penthouse;
            // Draw a simple chart to visualize the data
            const ctx = document.getElementById('roomsChart').getContext('2d');
            const roomsChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['Deluxe Suite', 'Family Suite', 'Luxury Penthouse'],
                    datasets: [{
                        label: 'Total Rooms Booked',
                        data: [data.deluxe, data.family, data.penthouse],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.5)',
                            'rgba(54, 162, 235, 0.5)',
                            'rgba(255, 206, 86, 0.5)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)'
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});