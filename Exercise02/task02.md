# Task 2: Peer-to-Peer Architecture for MMOGs

## Architectural Style Description

**Peer-to-Peer (P2P) Architecture for MMOGs:**
- Players connect directly to each other, not through central server
- Each player's computer acts as both client and server
- Game state is distributed across all connected players
- No single point of failure

## Comparison to Traditional Styles

| Architecture Style | Structure | Advantages | Disadvantages |
|-------------------|-----------|------------|---------------|
| **P2P (Paper)** | Distributed, no central server | Scalable, fault-tolerant | Complex synchronization |
| **Client-Server** | Central server, multiple clients | Simple, secure | Server bottleneck |
| **Layered** | Organized in layers | Clear separation | Performance overhead |
| **Microservices** | Small independent services | Flexible, maintainable | Network complexity |

## Key Benefits of P2P for MMOGs:
- **Scalability:** More players = more computing power
- **Cost-effective:** No expensive central servers
- **Resilience:** Game continues if some players disconnect

## Main Challenge:
- **Consistency:** Hard to keep game state synchronized across all players

## Conclusion:
P2P architecture suits MMOGs because it distributes load and costs, but requires complex algorithms to maintain consistent game state.