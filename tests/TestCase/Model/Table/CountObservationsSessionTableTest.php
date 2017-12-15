<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountObservationsSessionTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountObservationsSessionTable Test Case
 */
class CountObservationsSessionTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountObservationsSessionTable
     */
    public $CountObservationsSession;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
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
        $config = TableRegistry::exists('CountObservationsSession') ? [] : ['className' => CountObservationsSessionTable::class];
        $this->CountObservationsSession = TableRegistry::get('CountObservationsSession', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountObservationsSession);

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
