function showContent(btn) {
    const content = btn.getAttribute("data-content");
    document.getElementById("modalContent").innerText = content;
    document.getElementById("contentModal").style.display = "block";
}

function closeModal() {
    document.getElementById("contentModal").style.display = "none";
}

window.onclick = function(event) {
    let modal = document.getElementById("contentModal");
    if (event.target == modal) {
        modal.style.display = "none";
    }
}