<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountObservationsTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountObservationsTable Test Case
 */
class CountObservationsTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountObservationsTable
     */
    public $CountObservations;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_observations',
        'app.session',
        'app.count_observations_session'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountObservations') ? [] : ['className' => CountObservationsTable::class];
        $this->CountObservations = TableRegistry::get('CountObservations', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountObservations);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
