$(document).ready(function() {
    // Toggle between Login and Signup on homepage
    $('#toggleSignup').click(function(e) {
        e.preventDefault();
        let isSignup = $('#submitBtn').text() === 'Login';
        $('#formTitle').text(isSignup ? 'Join DormMate' : 'Welcome to DormMate');
        $('#submitBtn').text(isSignup ? 'Sign Up' : 'Login');
        $('#toggleText').html(
            isSignup 
                ? 'Already have an account? <a href="#" id="toggleSignup">Login</a>' 
                : 'Don\'t have an account? <a href="#" id="toggleSignup">Sign Up</a>'
        );
    });
});
/*    // Form submission (dummy redirect to dashboard)
    $('#authForm').submit(function(e) {
        e.preventDefault();
        window.location.href = '/dashboard'; // Redirect to dashboard
    });

    // Dashboard button clicks (just for demo)
    $('.btn-outline-primary').click(function() {
        alert('Feature coming soon!');
    });
});

$(document).ready(function() {
    // Existing login/signup toggle code...

    // Fetch and display tasks
    function loadTasks() {
        $.get('http://localhost:8080/api/tasks', function(tasks) {
            let taskList = '';
            tasks.forEach(task => {
                taskList += `<li>${task.description} - ${task.assignedTo}</li>`;
            });
            $('#taskList').html(taskList); // Add <ul id="taskList"> in dashboard.html
        });
    }

    // Add task on button click
    $('#addTaskBtn').click(function() {
        let task = {
            id: Date.now(), // Temp ID
            description: $('#taskDesc').val(),
            assignedTo: $('#taskAssignee').val()
        };
        $.ajax({
            url: 'http://localhost:8080/api/tasks',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(task),
            success: function() {
                loadTasks();
            }
        });
    });

    // Load tasks on dashboard load
    if (window.location.pathname.includes('dashboard.html')) {
        loadTasks();
    }
});*/