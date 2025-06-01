# Task 4: Architectural Patterns for Software Systems

## a) Whistleblowing System on the Internet

**Recommended Pattern:** **Layered Architecture**

**Why:**
- **Security layers:** Authentication → Encryption → Anonymous submission
- **Clear separation:** UI layer, business logic, data storage
- **Easy to secure:** Each layer can have different security controls

## b) Video Conferencing System

**Recommended Pattern:** **Client-Server with P2P Hybrid**

**Why:**
- **Server:** User management, authentication, room creation
- **P2P:** Direct video/audio streaming between participants
- **Scalable:** Reduces server load for media streaming
- **Efficient:** Lower latency for real-time communication

## c) GPS Tracker for Cats

**Recommended Pattern:** **Client-Server Architecture**

**Why:**
- **Simple and reliable:** Cat tracker (client) → Central server → Owner's app
- **Always available:** Server stores location history
- **Multiple clients:** Owner can check from phone, web, etc.
- **Low complexity:** Straightforward data flow for small device

## Summary Table:

| System | Pattern | Main Reason |
|--------|---------|-------------|
| Whistleblowing | Layered | Security and anonymity |
| Video Conference | Client-Server + P2P | Scalability and performance |
| Cat GPS Tracker | Client-Server | Simplicity and reliability |